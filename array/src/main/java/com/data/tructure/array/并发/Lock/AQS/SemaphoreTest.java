package com.data.tructure.array.并发.Lock.AQS;

import org.junit.Test;

import java.util.concurrent.*;

public class SemaphoreTest {


    @Test
    public void test() throws Exception {

        Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        System.out.println("i:" + finalI + "  剩余许可证:" + semaphore.availablePermits());
                        TimeUnit.MILLISECONDS.sleep((long) (finalI * 1000 * 0.8));

                        semaphore.release();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        sleep(100000);
    }

    @Test
    public void test66() throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 6000));
                        // 访问完后，释放
                        semp.release();
                        //availablePermits()指还剩多少个许可
                        System.out.println("NO:" + NO + " -----------------" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
        sleep(100000);
    }


    private void sleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("hello", 1);
    }

}
