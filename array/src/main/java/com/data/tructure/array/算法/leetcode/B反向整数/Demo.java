package com.data.tructure.array.算法.leetcode.B反向整数;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-06-12
 */
public class Demo {


    @Test
    public void test() throws Exception {

        int x = 234;

        System.out.println(x / 10);
        System.out.println(x % 10);

        System.out.println(solve(x));

        int b = 1234560;
        System.out.println(solve(b));

        int c = -987;
        System.out.println(solve(c));

        int h = -2147483646;
        System.out.println(solve(h));
    }

    public int solve(int num) {
        long res = 0;
        for (; num != 0; num /= 10) {
            res = res * 10 + num % 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }


    public int reverseInteger(int num) {

        if (num == 0 || (num < 10 && num > -10)) {
            return num;
        }

        long result = 0;
        for (; num != 0; num /= 10) {
            result = result * 10 + num % 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }


    @Test
    public void test2() throws Exception {
        int x = -123;
        System.out.println(reverseInteger2(x));
    }


    public int reverseInteger2(int num) {
        if (num == 0 || (num < 10 && num > -10)) {
            return num;
        }

        int temp = Math.abs(num);
        StringBuilder st = new StringBuilder(String.valueOf(temp));
        StringBuilder reverse = st.reverse();
        long result = Long.valueOf(reverse.toString());

        if (num > 0) {
            return result > Integer.MAX_VALUE ? 0 : (int) result;
        } else {
            return result < Integer.MIN_VALUE ? 0 : -(int) result;
        }
    }

}
