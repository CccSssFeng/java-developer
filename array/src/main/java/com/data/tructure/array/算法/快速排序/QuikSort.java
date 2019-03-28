package com.data.tructure.array.算法.快速排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cuishifeng
 * @date 2019-03-28
 */
public class QuikSort {


    @Test
    public void test() throws Exception {
        int[] arr = {30, 40, 60, 10, 20, 50};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int arr[], int left, int right) {
        int i = left;
        int j = right;
        if (i >= arr.length || j < 0) {
            return;
        }
        int temp = arr[i];

        if (left > right) {
            return;
        }
        while (i < j) {
            while (i < j && arr[j] > temp) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] < temp) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
