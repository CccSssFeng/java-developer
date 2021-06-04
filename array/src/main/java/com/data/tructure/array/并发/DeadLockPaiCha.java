package com.data.tructure.array.并发;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuishifeng
 * @date 2019-04-09
 */
public class DeadLockPaiCha {

    @Test
    public void test() throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            service.execute(new Tea());
        }
    }

    static class Tea implements Runnable {

        static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            lock.lock();
            System.out.println("打印");
        }
    }

    static class DeadLock implements Runnable {

        public int flag = 1;
        /**
         * 静态对象是类的所有对象共享的
         */
        private static Object o1 = new Object(), o2 = new Object();

        @Override
        public void run() {
            System.out.println("flag=" + flag);
            if (flag == 1) {
                synchronized (o1) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println("1");
                    }
                }
            }
            if (flag == 0) {
                synchronized (o2) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println("0");
                    }
                }
            }
        }

        public static void main(String[] args) {

            DeadLock td1 = new DeadLock();
            DeadLock td2 = new DeadLock();
            td1.flag = 1;
            td2.flag = 0;
            //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
            //td2的run()可能在td1的run()之前运行
            new Thread(td1).start();
            new Thread(td2).start();

        }
    }
}
