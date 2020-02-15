package com.data.tructure.array.算法.递归.青蛙跳台阶;

import org.junit.Test;

public class Test20200215 {

    /*
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 台阶 1 2 3 4
     * 组合 1 2 3
     */

    @Test
    public void test() throws Exception {
        System.out.println(combination(3));
    }

    public int combination(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return combination(n - 1) + combination(n - 2);
    }


}
