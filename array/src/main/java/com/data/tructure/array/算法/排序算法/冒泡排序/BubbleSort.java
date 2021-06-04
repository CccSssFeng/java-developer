package com.data.tructure.array.算法.排序算法.冒泡排序;

import org.junit.Test;

/**
 * 冒泡排序
 *
 * @author cuishifeng
 * @date 2019-03-14
 */
public class BubbleSort {

    public static void main(String[] args) {
        //        sort();
        //        sort2();
        //        sort3();
    }

    /**
     * 从小到达排序
     */
    public static void sort() {

        int[] arr = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void sort2() {
        int[] arr = {2, 5, 9, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("次数: " + i);
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    /**
     * 优化冒泡排序 减少不必要的循环
     */
    public static void sort3() {
        int[] arr = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};
        int i = arr.length - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    pos = j;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            i = pos;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


}
