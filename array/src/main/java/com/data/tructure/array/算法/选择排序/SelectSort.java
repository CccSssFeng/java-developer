package com.data.tructure.array.算法.选择排序;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-03-15
 */
public class SelectSort {

    @Test
    public void test() throws Exception {
        int[] arr = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};

        for (int out = 0; out < arr.length - 1; out++) {
            int minPos = out;
            for (int in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[minPos]) {
                    minPos = in;
                }
            }
            if (minPos != out) {
                int temp = arr[out];
                arr[out] = arr[minPos];
                arr[minPos] = temp;
            }
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


    @Test
    public void test2() throws Exception {

        int[] arr = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};
        int min;
        for (int out = 0; out < arr.length - 1; out++) {
            min = out;
            for (int in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }
            if (min != out) {
                int temp = arr[out];
                arr[out] = arr[min];
                arr[min] = temp;
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}
