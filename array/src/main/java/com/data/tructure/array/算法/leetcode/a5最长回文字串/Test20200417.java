package com.data.tructure.array.算法.leetcode.a5最长回文字串;

import org.junit.Test;

public class Test20200417 {

    @Test
    public void test() throws Exception {
        String s = "cbbd";
        s = "babad";
        System.out.println(longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        if (s == null || s.equals("") || s.length() <= 1) {
            return s;
        }
        int maxLen = 0;
        String longgest = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int len = j - i;
                    if (len > maxLen && isPalindrome(s.substring(i, j + 1))) {
                        maxLen = len;
                        longgest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longgest;
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            left++;
            right--;
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }

}
