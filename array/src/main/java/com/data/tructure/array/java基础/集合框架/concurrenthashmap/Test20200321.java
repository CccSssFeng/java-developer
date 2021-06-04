package com.data.tructure.array.java基础.集合框架.concurrenthashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Test20200321 {


    @Test
    public void test() throws Exception {

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("hello", 1);
        //        concurrentHashMap.put(null, 2);
        //        concurrentHashMap.put(null, 3);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        hashMap.put(null, 2);

        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("hello", 1);

        hashtable.keys();

    }
}
