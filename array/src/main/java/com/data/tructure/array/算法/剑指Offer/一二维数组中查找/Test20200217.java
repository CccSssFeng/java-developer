package com.data.tructure.array.算法.剑指Offer.一二维数组中查找;

import org.junit.Test;

public class Test20200217 {

    /*
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    @Test
    public void test() throws Exception {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(find(array, -5));
    }

    public boolean find(int[][] array, int target) {
        int c = array.length - 1;
        int r = 0;
        while (r < array.length && c >= 0) {
            if (array[r][c] == target) {
                return true;
            }
            if (array[r][c] > target) {
                c--;
            }
            if (array[r][c] < target) {
                r++;
            }
        }
        return false;
    }

}
