package com.data.tructure.array.算法.leetcode.a9回文数;

import org.junit.Test;

public class Test20200419 {

    @Test
    public void test() throws Exception {
        System.out.println(isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        String s = x + "";
        System.out.println("s:" + s);
        int r = s.length() - 1;
        int l = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
