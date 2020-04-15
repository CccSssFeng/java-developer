package com.data.tructure.array.并发.并发工具类;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test20200414 {

    @Test
    public void test() throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        countDownLatch.countDown();

        countDownLatch.await();

        ReentrantLock reentrantLock = new ReentrantLock();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lockInterruptibly();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        cyclicBarrier.await();

        cyclicBarrier.reset();

    }

}
