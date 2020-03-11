package com.data.tructure.array.算法.剑指Offer.一二维数组中查找;

import org.junit.Test;

public class Test20200311 {


    public boolean find2Array(int[][] array, int target) {
        if (array == null && array[0] == null) {
            return false;
        }
        int c = array[0].length - 1;
        int r = 0;

        while (r < array.length && c >= 0) {
            if (array[r][c] == target) {
                return true;
            } else if (array[r][c] > target) {
                c--;
            } else if (array[r][c] < target) {
                r++;
            }
        }
        return false;
    }


    @Test
    public void test() throws Exception {
//        int[][] array = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};
        int[][] array = {{-5}};
        System.out.println(find2Array(array, -5));
    }

}
