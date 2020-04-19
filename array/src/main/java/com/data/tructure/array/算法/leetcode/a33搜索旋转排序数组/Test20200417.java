package com.data.tructure.array.算法.leetcode.a33搜索旋转排序数组;

import org.junit.Test;

public class Test20200417 {

    @Test
    public void test() throws Exception {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchNums(array, 6));
    }


    /*
     * 数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
     */
    public int searchNums(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int right = array[end];
        int left = array[start];
        while (start <= end) {
            int p = (start + end) / 2;
            if (array[p] == target) {
                return p;
            } else {
                if (array[p] < right) {
                    if (target > array[p] && target < right) {
                        start = p + 1;
                    } else {
                        end = p - 1;
                    }
                } else {
                    if (array[p] > target && target > right) {
                        end = p - 1;
                    } else {
                        start = p + 1;
                    }
                }
            }
        }
        return -1;
    }
}
