package com.data.tructure.array.并发;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author cuishifeng
 * @date 2019-04-08
 */
public class ThreadPoolTest {


    @Test
    public void test() throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝提交线程到线程池");
            }
        });

        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        for (int i = 0; i < 5; i++) {
            Future<String> submit = executor.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    return "success";
                }
            });
            System.out.println(submit.get());
        }
    }

    @Test
    public void test2() throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 500,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.AbortPolicy());
//        executor.prestartAllCoreThreads();

        System.out.println("初始化: "+executor);
        for (int i = 0; i < 15; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        System.out.println("1: "+executor);
        System.out.println("1: "+executor.getActiveCount());

        TimeUnit.SECONDS.sleep(2);

        System.out.println("2: "+executor);
        System.out.println("2: "+executor.getActiveCount());


//        executor.shutdown();
//        System.out.println(executor.isShutdown());
//        System.out.println(executor);
//
//        System.out.println("executor.isTerminated(): " + executor.isTerminated());
//        System.out.println(executor);
//
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(executor);
    }

    @Test
    public void test4() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
    }
}
