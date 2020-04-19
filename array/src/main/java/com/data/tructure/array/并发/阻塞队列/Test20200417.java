package com.data.tructure.array.并发.阻塞队列;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Test20200417 {

    @Test
    public void test() throws Exception {

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        arrayBlockingQueue.put(1);
        arrayBlockingQueue.poll();

        // queue 不是 deque
        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue();
        blockingQueue.put(1);
        blockingQueue.poll();

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.put(1);
        linkedBlockingDeque.poll();


    }
}
