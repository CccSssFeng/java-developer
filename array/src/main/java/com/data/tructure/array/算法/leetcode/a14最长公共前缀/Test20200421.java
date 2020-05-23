package com.data.tructure.array.算法.leetcode.a14最长公共前缀;

import org.junit.Test;

public class Test20200421 {

    @Test
    public void test() throws Exception {

        String[] strs = {"aa", "a"};
        System.out.println(longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = "";
        int len = strs[0].length();
        String first = strs[0];
        for (int i = 0; i < len; i++) {
            Character s = first.charAt(i);
            boolean isSame = true;
            for (int j = 0; j < strs.length; j++) {
                int le = strs[j].length() - 1;
                if (i>le || strs[j].charAt(i) != s) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                prefix = prefix + s;
            } else {
                break;
            }
        }
        return prefix;
    }

}
