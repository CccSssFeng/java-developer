package com.data.tructure.array.redis.分布式锁;

import com.data.tructure.array.redis.jedis.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisLockUtil {

    private static final int MAX_TIME_OUT = 30;
    private static final Long RELEASE_SUCCESS = 1L;
    private static volatile String uniqueValue;


    /*
     * String set(String key, String value, String nxxx, String expx, long time);
     * 该方法是： 存储数据到缓存中，并制定过期时间和当Key存在时是否覆盖。
     * nxxx： 只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
     * expx： 只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
     * time： 过期时间，单位是expx所代表的单位。
     */

    /**
     * 上锁
     */
    public static void lock(String lockName) {
        if (!tryLock(lockName, MAX_TIME_OUT)) {
            while (!tryLock(lockName, MAX_TIME_OUT)) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean tryLock(String key, int seconds) {
        Jedis jedis = JedisClient.getJedis();
        try {
            SetParams setParams = new SetParams();
            setParams.nx();
            setParams.ex(seconds);
            String uuid = UUID.randomUUID().toString();
            String result = jedis.set("LOCK_KEY_PREFIX" + key, uuid, setParams);
            if ("OK".equals(result)) {
                uniqueValue = uuid;
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("set redis lock error", e);
        } finally {
            JedisClient.closeJedis(jedis);
        }
        return false;
    }

    /**
     * if redis.call("get",KEYS[1]) == ARGV[1] then
     * return redis.call("del",KEYS[1])
     * else
     * return 0
     * end
     * <p>
     * 释放锁
     */
    public static boolean unlock(String lockName) {
        Jedis jedis = JedisClient.getJedis();
        try {
            String script =
                    "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result =
                    jedis.eval(script, Collections.singletonList(lockName), Collections.singletonList(uniqueValue));
            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisClient.closeJedis(jedis);
        }
        return false;
    }

}
