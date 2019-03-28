package com.data.tructure.array.集合框架.map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author cuishifeng
 * @date 2019-03-13
 */
public class HashMapLearn {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap(16);

        hashMap.put("hello", "you");

        hashMap.get("hello");

        for (int i = 0; i < 20; i++) {
            // 1. 使用 Collections.synchronizedMap 实现线程安全操作
            Collections.synchronizedMap(hashMap).put("hello" + i, i);
        }

        hashMap.forEach((k, v) -> System.out.println(k + " - " + v));

        // 2. HashMap可以使用null作为key，而 HashTable 则不允许null作为key

        // 3. HashMap的初始容量为16，HashTable初始容量为11，两者的填充因子默认都是0.75
    }

    @Test
    public void test() throws Exception {

        System.out.println(10 >> 2);
    }

    @Test
    public void test2() throws Exception {

        // 二进制转换规则
        // 获得 十进制 46 二进制写法
        // 0010 1110
        // 8765 43210  2的n次幂
        // 256 128 64 32 16 8 4 2 1
        // ... 32*1=32 16*0=0  8*1=8 4*1=4 2*1=2 1*0=0
        // 32+8+4+2 = 46

        // 二进制加法 逢二进一

        int d = Integer.parseInt("00101110", 2);
        System.out.println("二进制转为十进制: " + d);

        // 负数
        // 1、 二进制位取反 1 换成 0 ; 0 换成 1
        // 2、 然后加 1
        // 因为计算机是64位的 所以前面的必须都换成 1 才行出来的结果才是对的
        // 这里简化处理了 没有写最高位的 1 所以结果是不对的
        int d2 = Integer.parseInt("11010010", 2);
        System.out.println("二进制转为十进制: " + d2);

        String d3 = Integer.toBinaryString(-46);
        System.out.println(d3);

    }

    @Test
    public void test3() throws Exception {
        int i = hash("hello");
        System.out.println(i);
    }

    static final int hash(Object key) {
//        int h ;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        int h = key.hashCode();
        int c = h >>> 16;
        int d = h ^ c;
        System.out.println("hashcode: " + h + " >>>: " + c + " ^: " + d);
        return d;
    }
}
