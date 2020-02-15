package com.data.tructure.array.算法.递归.斐波那契数列;

import org.junit.Test;

public class Test20200215 {

    /*
     * 1、1、2、3、5、8、13、21、34、……在数学上
     * 求第 n 项的值是多少。
     */

    @Test
    public void test() throws Exception {
        System.out.println(getValue(6));
    }

    public int getValue(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return getValue(n - 1) + getValue(n - 2);
    }

}
