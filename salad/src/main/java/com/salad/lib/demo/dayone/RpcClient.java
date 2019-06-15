package com.salad.lib.demo.dayone;

import com.salad.framework.client.ClientProxy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author cuishifeng
 * @date 2019-05-13
 */
public class RpcClient {

    public static void main(String[] args) throws Exception {

        final UserService userService = ClientProxy.create(UserServiceImpl.class, "127.0.0.1", 5566);
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    String name = userService.getName(Thread.currentThread().getName());
                    System.out.println(name);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
