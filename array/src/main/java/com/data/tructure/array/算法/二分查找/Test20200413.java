package com.data.tructure.array.算法.二分查找;

import org.junit.Test;

public class Test20200413 {

    @Test
    public void test() throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 8, 10};
        System.out.println(find(array, 0));
    }

    public int find(int[] array, int num) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int p = (start + end) / 2;
            if (num == array[p]) {
                return num;
            } else if (num > array[p]) {
                start = p + 1;
            } else if (num < array[p]) {
                end = p - 1;
            }
        }
        return -1;
    }
}
