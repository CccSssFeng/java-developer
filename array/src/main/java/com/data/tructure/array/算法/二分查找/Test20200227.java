package com.data.tructure.array.算法.二分查找;

import org.junit.Test;

public class Test20200227 {


    @Test
    public void test() throws Exception {
        int[] array = {1, 4, 8, 12, 13, 18, 20, 31, 33, 60, 90};
        System.out.println(find(array, 100));
    }

    public boolean find(int[] array, int target) {
        if (array == null || array.length < 1) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int p = (start + end) / 2;
            if (array[p] == target) {
                return true;
            } else if (array[p] > target) {
                end = p - 1;
            } else {
                start = p + 1;
            }
        }
        return false;
    }

}
