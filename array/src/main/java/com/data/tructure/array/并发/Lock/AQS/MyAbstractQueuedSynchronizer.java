package com.data.tructure.array.并发.Lock.AQS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

public class MyAbstractQueuedSynchronizer {


    private volatile int state = 0;

    private static final Unsafe unsafe = getUnsafe();

    private static final long stateOffset;

    private volatile Thread threadHold;

    private volatile ConcurrentLinkedQueue<Thread> threadQueue = new ConcurrentLinkedQueue();

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(MyAbstractQueuedSynchronizer.class.getDeclaredField("state"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public void lock() {
        Thread current = Thread.currentThread();
        for (; ; ) {
            if (compareAndSwapInt(0, 1)) {
                this.threadHold = current;
                break;
            }
            threadQueue.add(current);
            LockSupport.park();
        }
    }

    public void unLock() {
        if (getState() != 0) {
            Thread current = Thread.currentThread();
            if (current == this.threadHold) {
                compareAndSwapInt(this.state, 0);
            }
            if (threadQueue.size() > 0) {
                Thread waitNotifyThread = threadQueue.poll();
                LockSupport.unpark(waitNotifyThread);
            }

        }
    }

    public boolean compareAndSwapInt(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    private int getState() {
        return this.state;
    }


    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(Unsafe.class);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

}
