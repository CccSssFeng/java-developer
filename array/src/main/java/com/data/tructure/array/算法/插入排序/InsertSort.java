package com.data.tructure.array.算法.插入排序;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-03-20
 */
public class InsertSort {


    @Test
    public void test() throws Exception {

        int[] arr = {2, 5, 9, 1};

        for (int out = 1; out < arr.length; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
        // 2 5 9 1
        // 2 5 9 9
        // 2 5 5 9
        // 2 2 5 9
        // 1 2 5 9

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void test2() throws Exception {
        int a = 2;
        int b = 2;
        System.out.println(a--);
        System.out.println(--b);
    }

    static int[] arr = {3, 1, 2, 5, 6, 0, 9, 4, 8, 7};

    @Test
    public void test3() throws Exception {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            int index = arr[out];
            for (in = out; in > 0 && arr[in - 1] > index; in--) {
                arr[in] = arr[in - 1];
            }
            arr[in] = index;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void test4() throws Exception {

    }
}
