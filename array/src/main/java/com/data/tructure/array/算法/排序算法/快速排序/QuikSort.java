package com.data.tructure.array.算法.排序算法.快速排序;

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


    public void quikly(int[] arr, int left, int right) {
        if (left < 0 || right > arr.length) {
            return;
        }
        int i = left;
        int j = right;

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
        quikly(arr, left, i - 1);
        quikly(arr, i + 1, right);
    }


    public void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void choose(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = min; j < arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public void insert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Test
    public void test2() throws Exception {
        int[] arr = {30, 40, 60, 10, 20, 50};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
