package com.data.tructure.array.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author cuishifeng
 * @date 2019-08-15
 */
public class DeadLockTest {

    private static Object locka = new Object();
    private static Object lockb = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new LockOne(), "线程1");
        Thread thread2 = new Thread(new LockTwo(), "线程2");
        thread1.start();
        thread2.start();
        //        new DeadLockTest().deadLock();
    }


    static class LockOne implements Runnable {

        @Override
        public void run() {
            synchronized (locka) {
                try {
                    System.out.println(Thread.currentThread().getName() + " get locka ");
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " after sleep 500ms ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " wait get lockb");
                synchronized (lockb) {
                    System.out.println(Thread.currentThread().getName() + " get lockb ");
                }
            }
        }
    }

    static class LockTwo implements Runnable {

        @Override
        public void run() {
            synchronized (lockb) {
                try {
                    System.out.println(Thread.currentThread().getName() + " get lockb ");
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " after sleep 500ms ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " wait get locka");
                synchronized (locka) {
                    System.out.println(Thread.currentThread().getName() + " get locka ");
                }
            }
        }
    }

    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locka) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " get locka ing!");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " after sleep 500ms!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " need lockb!Just waiting!");
                    synchronized (lockb) {
                        System.out.println(Thread.currentThread().getName() + " get lockb ing!");
                    }
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockb) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " get lockb ing!");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " after sleep 500ms!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " need locka! Just waiting!");
                    synchronized (locka) {
                        System.out.println(Thread.currentThread().getName() + " get locka ing!");
                    }
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
