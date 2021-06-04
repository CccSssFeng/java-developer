package com.data.tructure.array.算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cuishifeng
 * @date 2019-03-28
 */
public class Demo {

    int[] arr = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};

    /**
     * 冒泡排序
     */
    @Test
    public void maopaotest() throws Exception {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void choosetest() throws Exception {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    int[] arr2 = {2, 5, 9, 1, 3, 0, 4, 8, 6, 7};

    @Test
    public void inserttest() throws Exception {

        int[] arr = {3, 1, 2, 5, 6, 0, 9, 4, 8, 7};
        for (int out = 1; out < arr.length; out++) {
            for (int in = out; in > 0; in--) {
                if (arr[in] < arr[in - 1]) {
                    int temp = arr[in - 1];
                    arr[in - 1] = arr[in];
                    arr[in] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void quicktest() throws Exception {

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        if (i > arr.length - 1 || j < 0) {
            return;
        }
        if (i >= j) {
            return;
        }
        // 基准数据
        int temp = arr[i];
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
