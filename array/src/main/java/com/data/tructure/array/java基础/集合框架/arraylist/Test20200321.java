package com.data.tructure.array.java基础.集合框架.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Test20200321 {

    @Test
    public void test() throws Exception {

        ArrayList<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());

        // 元素追加到集合尾部
        //        list.add(2);
        // 添加到指定位置数据 插入
        list.add(2, 1);
        // 用指定的元素代替集合指定位置处的元素 覆盖
        //        list.set(5, 1);

        Vector<Integer> vector = new Vector<>(10);
        vector.add(1);

        List<Integer> synchronizedList = Collections.synchronizedList(list);

    }

}
