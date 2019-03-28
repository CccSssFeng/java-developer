package com.data.tructure.array.算法.选择排序;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-03-18
 */
public class DemoTest {

    @Test
    public void test() throws Exception {

        int[] arr = {2, 5, 3, 4, 9, 7, 6};
        int minPos;
        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = minPos; j < arr.length - 1; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;
            }
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
