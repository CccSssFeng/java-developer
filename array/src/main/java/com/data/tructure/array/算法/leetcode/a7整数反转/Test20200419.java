package com.data.tructure.array.算法.leetcode.a7整数反转;

import org.junit.Test;

public class Test20200419 {

    @Test
    public void test() throws Exception {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(1534236469));
        System.out.println(964632435 + " - " + 1 % 10);
        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        int sum = 0;
        int cur = x;
        boolean isExit = true;
        while (isExit) {
            if (cur / 10 == 0) {
                isExit = false;
            }
            if (sum < Integer.MIN_VALUE / 10 || sum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            sum = cur % 10 + sum * 10;
            cur = cur / 10;
        }

        return sum;
    }

}
