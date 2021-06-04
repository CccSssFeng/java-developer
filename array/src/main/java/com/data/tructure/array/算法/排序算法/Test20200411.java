package com.data.tructure.array.算法.排序算法;

import org.junit.Test;

import java.util.Arrays;

public class Test20200411 {


    @Test
    public void test() throws Exception {

        int[] array = {3, 2, 5, 1, 6, 4, 7};

        // 冒泡排序
        //        sort(array);
        //        chooseSort(array);
        //        insertSort(array);
        quicklySort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public void sort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void chooseSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void quicklySort(int[] array, int L, int R) {
        if (array == null || L >= R) {
            return;
        }
        int left = L;
        int right = R;
        int p = array[L];

        while (left < right) {

            while (left < right && array[right] >= p) {
                right--;
            }
            if (left < right) {
                array[L] = array[right];
            }
            while (left < right && array[left] <= p) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[left] = p;
        quicklySort(array, L, left - 1);
        quicklySort(array, left + 1, R);
    }
}
