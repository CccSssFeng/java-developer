package com.data.tructure.array.java基础.集合框架.copy;

import org.junit.Test;

public class Test20200410 {

    @Test
    public void test() throws Exception {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[10];

        System.arraycopy(a, 0, b, 0 + 1, a.length - 0);

        for (int n : b) {
            System.out.print(n + ",");
        }
    }
}
