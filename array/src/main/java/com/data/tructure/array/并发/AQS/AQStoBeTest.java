package com.data.tructure.array.并发.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cuishifeng
 * @date 2019-05-14
 */
public class AQStoBeTest {

    private static ReentrantLock lock = new ReentrantLock();



    private static int num = 10;
    private static int getNum = 0;

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 50; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    count();
                }
            });
        }

    }

    public static void count() {
        try {
            lock.lock();

            if (num > 0) {
                num--;
                getNum++;
                System.out.println(Thread.currentThread().getName() + " - 抢到第 : " + getNum);
            }
            System.out.println("还剩余: " + num);
            if (num == 0) {
                System.out.println("票卖完~~~");
            }

        } finally {
            lock.unlock();
        }

    }
}
