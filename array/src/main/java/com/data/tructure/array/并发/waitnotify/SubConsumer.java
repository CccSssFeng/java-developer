package com.data.tructure.array.并发.waitnotify;

import org.checkerframework.checker.units.qual.C;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SubConsumer {

    private static LinkedList<Integer> list = new LinkedList<>();
    private static Object object = new Object();


    static class Provider extends Thread {

        @Override
        public void run() {

            synchronized (object) {
                while (true) {
                    if (list.size() >= 10) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int num = new Random().nextInt() * 10;
                    System.out.println("生产者:" + num);
                    list.push(num);
                    object.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {

        @Override
        public void run() {

            synchronized (object) {
                while (true) {
                    if (list.isEmpty()) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer pop = list.pop();
                    System.out.println("消费者:" + pop);
                    object.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread provider = new Provider();
        provider.start();
        Thread consumer = new Consumer();
        consumer.start();
    }
}
