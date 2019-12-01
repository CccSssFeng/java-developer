package com.data.tructure.array.并发;

import com.data.tructure.array.并发.Lock.AQS.MyAbstractQueuedSynchronizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        //买票
//        while (flag) {
            buyTicket();
//        }
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
//
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

}
