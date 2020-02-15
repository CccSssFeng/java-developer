package com.data.tructure.array.算法.排序算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test20200125 {

    @Test
    public void test() throws Exception {
        int[] array = new int[]{3, 9, 2, 0, 7, 8, 5, 1, 4, 2, 6};

//        sort(array);
//        chooseSort(array);
//        insertSort(array);
//        Arrays.sort(array);
//        quicklySort(array, 0, array.length - 1);
//        quicklySort2(array, 0, array.length - 1);
        quicklySort3(array, 0, array.length - 1);
        System.out.println("array:" + Arrays.toString(array));

    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean exchange = false;
            System.out.println("i " + i);
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void chooseSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }


    /**
     * 插入排序
     *
     * @param array
     */
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     * 挖坑+分治 方式
     */
    public void quicklySort(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int left = L;
        int right = R;
        int pivot = array[L];
        // 实现挖坑
        while (left < right) {

            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }

            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
        }
        if (left >= right) {
            array[left] = pivot;
        }
        // 实现分治
        quicklySort(array, L, right - 1);
        quicklySort(array, left + 1, R);
    }

    /**
     * 快速排序
     * 交换指针+分治 方式
     */
    public void quicklySort2(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int position = position(array, L, R);
        quicklySort2(array, L, position - 1);
        quicklySort2(array, position + 1, R);
    }

    public void quicklySort3(int[] array, int L, int R) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> first = new HashMap<>();
        first.put("left", L);
        first.put("right", R);
        stack.push(first);

        while (!stack.isEmpty()) {
            Map<String, Integer> map = stack.pop();
            Integer left = map.get("left");
            Integer right = map.get("right");
            int position = position(array, left, right);
            if (left < position - 1) {
                Map<String, Integer> p = new HashMap<>();
                p.put("left", left);
                p.put("right", position - 1);
                stack.push(p);
            }
            if (right > position + 1) {
                Map<String, Integer> p = new HashMap<>();
                p.put("left", position + 1);
                p.put("right", right);
                stack.push(p);
            }
        }
    }


    public int position(int[] array, int L, int R) {
        int left = L;
        int right = R;
        int pivot = array[L];
        while (left != right) {

            while (left < right && array[right] > pivot) {
                right--;
            }

            while (left < right && array[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        int p = array[left];
        array[left] = pivot;
        array[L] = p;
        return left;
    }


}
