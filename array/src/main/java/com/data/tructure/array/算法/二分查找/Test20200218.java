package com.data.tructure.array.算法.二分查找;

import org.junit.Test;

public class Test20200218 {

    @Test
    public void test() throws Exception {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(abFind(array, 1));
    }

    public int abFind(int[] array, int target) {
        int L = 0, R = array.length - 1;
        int min;
        while (L <= R) {
            min = (L + R) / 2;
            System.out.println("min:" + min);
            if (array[min] == target) {
                return min;
            } else if (array[min] < target) {
                L = min + 1;
            } else {
                R = min - 1;
            }
        }
        return -1;
    }
}
