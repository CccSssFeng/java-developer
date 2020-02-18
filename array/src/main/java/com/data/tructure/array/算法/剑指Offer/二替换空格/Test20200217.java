package com.data.tructure.array.算法.剑指Offer.二替换空格;

import org.junit.Test;

public class Test20200217 {

    /*
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy.
     */
    @Test
    public void test() throws Exception {
        String str = "We Are Happy.";
        System.out.println(replaceSpace(str));
    }

    public String replaceSpace(String str) {
        int newLen = str.length();
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                newLen = newLen + 2;
            }
        }
        System.out.println(newLen);
        char[] newChar = new char[newLen];
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " " + i);
            index++;
            if (str.charAt(i) == ' ') {
                newChar[index] = '%';
                newChar[index + 1] = '2';
                newChar[index + 2] = '0';
                index = index + 2;
            } else
                newChar[index] = str.charAt(i);
        }

        return String.valueOf(newChar);
    }


    @Test
    public void testFor() throws Exception {

        String str = "abc";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

    }


}
