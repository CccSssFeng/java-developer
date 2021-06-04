package com.data.tructure.array.并发.原子操作类;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Test20200414 {

    @Test
    public void test() throws Exception {

        AtomicInteger integer = new AtomicInteger();
        System.out.println(integer.addAndGet(1));
        System.out.println(integer.addAndGet(1));

        AtomicLong atomicLong = new AtomicLong();

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.getAndSet(true);

        //      AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray();

        AtomicReference atomicReference = new AtomicReference();

    }
}
