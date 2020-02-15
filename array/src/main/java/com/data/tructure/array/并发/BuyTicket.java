package com.data.tructure.array.并发;

import com.data.tructure.array.并发.Lock.AQS.MyAbstractQueuedSynchronizer;
import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BuyTicket implements Runnable {

    //票数
    private int ticketNum = 10;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    //标志位
    private boolean flag = true;

    private static MyAbstractQueuedSynchronizer myAbstractQueuedSynchronizer = new MyAbstractQueuedSynchronizer();

    @Override
    public void run() {
        buyTicket();
    }

    public void buyTicket() {
        //模仿网络延时
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myAbstractQueuedSynchronizer.lock();

        if (ticketNum <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "-拿到了第" + ticketNum-- + "票 卖出" + atomicInteger.addAndGet(1));
        if (atomicInteger.get() > 10) {
            System.err.println("== 超卖票 ==");
        }

        myAbstractQueuedSynchronizer.unLock();
    }


    public static void main(String[] args) {
        BuyTicket synTest = new BuyTicket();

//        Thread A = new Thread(synTest, "A");
//        Thread B = new Thread(synTest, "B");
//        Thread C = new Thread(synTest, "C");
//        Thread D = new Thread(synTest, "D");
//
//        A.start();
//        B.start();
//        C.start();
//        D.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(synTest);
        }

    }


    @Test
    public void unsafeTest() throws Exception {
        // Unsafe讲解
        // https://juejin.im/entry/59a6775d6fb9a0249d617cb8

        // 类加载器
        // https://www.cnblogs.com/crazymakercircle/p/9824111.html

        Unsafe unsafe = Unsafe.getUnsafe();
        // Unsafe unsafe = new Unsafe();

        AtomicInteger atomicInteger = new AtomicInteger();

    }

    @Test
    public void SynchronousQueue() throws Exception {

        ExecutorService service =
                new ThreadPoolExecutor(2, 10, 100, TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.CallerRunsPolicy());

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread name :" + Thread.currentThread().getName() + " i: " + finalI);
                    try {
                        cyclicBarrier.await();
//                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

//        countDownLatch.await();
        cyclicBarrier.await();
        System.out.println("hello yes");

        try {
            TimeUnit.MILLISECONDS.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
