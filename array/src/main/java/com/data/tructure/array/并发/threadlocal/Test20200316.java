package com.data.tructure.array.并发.threadlocal;

import org.junit.Test;

public class Test20200316 {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Test
    public void test() throws Exception {

        threadLocal.set("hello");

        System.out.println(threadLocal.get());

        threadLocal.remove();
    }
}
