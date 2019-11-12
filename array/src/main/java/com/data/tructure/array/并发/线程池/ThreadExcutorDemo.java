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
                    new ArrayBlockingQueue<Runnable>(2),
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

    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1,
                        1, 100000, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("name: " + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
