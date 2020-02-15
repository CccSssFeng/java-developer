package com.data.tructure.array.并发.Lock.AQS;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {


    @Test
    public void CyclicBarrier() throws Exception {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("全队结合完毕");
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        TimeUnit.MILLISECONDS.sleep((long) (finalI * 1000 * 0.8));
                        System.out.println("i:" + finalI + "  到达屏障的数:" + cyclicBarrier.getNumberWaiting());
                        cyclicBarrier.await();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        executorService.shutdown();
        sleep(100000);
    }


    private void sleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
