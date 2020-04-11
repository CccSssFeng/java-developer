package com.data.tructure.array.java基础.集合框架.treemap;

import org.junit.Test;

import java.util.TreeMap;

public class Test20200410 {

    @Test
    public void test() throws Exception {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "1");
        treeMap.put(5, "5");
        treeMap.put(3, "3");
        treeMap.put(2, "2");

        treeMap.forEach((k, v) -> System.out.println("k-" + k + ",v-" + v));
    }

}
