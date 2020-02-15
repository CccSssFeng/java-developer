package com.data.tructure.array.并发.Lock.AQS;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractQueuedSynchronizerTest {


    @Test
    public void test() throws Exception {

//        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new NonReentrantLock();

        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        reentrantLock.lock();
                        reentrantLock.lockInterruptibly();
                        TimeUnit.MILLISECONDS.sleep(2000);
                        System.out.println("thread:" + Thread.currentThread().getName() + " i:" + finalI);
                        reentrantLock.unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @Test
    public void lockInterruptibly() throws Exception {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        try {
            reentrantLock.lock();

            reentrantLock.lockInterruptibly();
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println("thread:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

}
