package com.data.tructure.array.限流.令牌桶;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

public class GuavaRateLimiter {


    @Test
    public void test() throws Exception {

        RateLimiter rateLimiter = RateLimiter.create(1);

        rateLimiter.setRate(2);

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {

            rateLimiter.acquire();
            System.out.println("hello " + i);
        }
        long e = System.currentTimeMillis();
        System.out.println("结束：" + (e - l) / 1000);
    }

}
