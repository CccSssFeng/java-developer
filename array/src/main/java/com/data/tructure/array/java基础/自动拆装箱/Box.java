package com.data.tructure.array.java基础.自动拆装箱;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-08
 */
public class Box {

    @Test
    public void test() throws Exception {

        Integer a = 128;
        Integer b = 128;

        Integer c = 127;
        Integer d = 127;

        System.out.println(a == b);
        System.out.println(c == d);

    }
}
