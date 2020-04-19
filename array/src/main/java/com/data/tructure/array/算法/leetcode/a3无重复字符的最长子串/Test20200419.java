package com.data.tructure.array.算法.leetcode.a3无重复字符的最长子串;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Test20200419 {

    @Test
    public void test() throws Exception {
        String s = "abcabcbb";
        s= " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> hashSet = new HashSet<>();
        int i = 0, j = 0;
        int max = 0;
        while (i < len && j < len) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j++));
                max = Math.max(max, (j - i));
            } else {
                hashSet.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
