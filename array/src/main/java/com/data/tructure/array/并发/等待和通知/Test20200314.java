package com.data.tructure.array.并发.等待和通知;

import org.junit.Test;

public class Test20200314 extends Thread {


    @Test
    public void test() throws Exception {
        talk();

    }

    public synchronized void talk() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }


    static class Demo extends Thread {


    }

}
