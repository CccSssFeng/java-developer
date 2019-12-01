package com.data.tructure.array.并发.线程池;


import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author cuishifeng
 * @date 2019-08-26
 */
public class ThreadExcutorDemo {

    static ThreadPoolExecutor executors =
            new ThreadPoolExecutor(
                    1,
                    5,
                    1,
                    TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(2),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.DiscardPolicy());
    // 拒绝策略
    // AbortPolicy            拒绝执行 弹出异常
    // CallerRunsPolicy       创建线程执行任务 这种策略任务不会被丢弃
    // DiscardPolicy          不处理新任务
    // DiscardOldestPolicy    抛弃最老的任务，就是从队列取出最老的任务然后放入新的任务进行执行

    // 阻塞队列
    // ArrayBlockingQueue

    @Test
    public void test() throws Exception {

        for (int i = 0; i < 20; i++) {
            int num = i;
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i: " + num + " name:" + Thread.currentThread().getName() +
                            " Active:" + executors.getActiveCount() +
                            " Queue:" + executors.getQueue().size() +
                            " Completed:" + executors.getCompletedTaskCount() +
                            " TaskCount:" + executors.getTaskCount());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
//        TimeUnit.SECONDS.sleep(20);
    }


    // 异常捕获

    @Test
    public void test1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("name: " + Thread.currentThread().getName());
                        Object a = null;
                        System.out.println(a.hashCode());
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
        }
    }

    @Test
    public void newFixedThreadPool() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Future<?> future = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("name: " + Thread.currentThread().getName());
                    Object a = null;
                    System.out.println(a.hashCode());
                }
            });
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    @Test
    public void newCachedThreadPool() throws Exception {
        // https://www.jianshu.com/p/376d368cb44f
        // https://segmentfault.com/a/1190000011207824

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello newCachedThreadPool");
            }
        });
    }

    @Test
    public void newSingleThreadExecutor() throws Exception {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread: " + Thread.currentThread().getName());
                }
            });
        }

        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Test
    public void newScheduledThreadPool() throws Exception {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("current Time" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, 1, 5, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("current Time" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, 1, 10, TimeUnit.SECONDS);

        TimeUnit.DAYS.sleep(1);
    }


}
