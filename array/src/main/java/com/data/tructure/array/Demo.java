package com.data.tructure.array;

import org.junit.Test;

import java.util.Arrays;

public class Demo {


    @Test
    public void test() throws Exception {
        int[][] array = {{3, 7}, {2, 9}, {8, 10}};
        System.out.println(minNum(array));
    }

    //     3  7
    //  2          9
    //          8    10
    //      4            12
    //               10      13

    public int minNum(int[][] dates) {

        if (dates == null || dates.length <= 0) {
            return 0;
        }
        if (dates.length == 1) {
            return 1;
        }
        int len = dates.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < dates.length - 1; i++) {
            start[i] = dates[i][0];
            end[i] = dates[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        for (; s < len; s++) {
            if (end[s] > start[s]) {
                e++;
            }
        }
        return e;
    }

}

