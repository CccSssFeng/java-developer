package com.data.tructure.array.lock;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuishifeng
 * @date 2019-04-04
 */
public class LockDemo {


    @Test
    public void test() throws Exception {

        Executor executor = Executors.newScheduledThreadPool(30);
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }
    }

    /**
     * 原子类
     *
     * @throws Exception
     */
    @Test
    public void atom() throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger.get());
    }

    static class Task implements Runnable {
        static int count = 10;
        static int aa = 0;
        ReentrantLock reentrantLock = new ReentrantLock();

        @Override
        public void run() {
            reentrantLock.lock();
            if (count > 0) {
                count--;
                aa++;
            }
            reentrantLock.unlock();
            System.out.println(count + " - " + aa);
        }

//        @Override
//        public void run() {
//            synchronized (Task.class){
//            if (count > 0) {
//                count--;
//                aa++;
//            }
//            System.out.println(count + " - " + aa);
//            }
//        }
    }


}
