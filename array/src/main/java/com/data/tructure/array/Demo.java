package com.data.tructure.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo {


    @Test
    public void test() throws Exception {
        // 1 2 2 3 4 4 4

    }


    public int[] getTop(String[] array, int k) {
        if (array == null || array.length == 0) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();


        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
        }
        return getNum(k, hashMap);

    }

    public int[] getNum(int k, HashMap<String, Integer> hashMap) {
        int[] nums = new int[k];
        int max = 0;
        String maxKey = "";
        for (int i = 0; i < k; i++) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            hashMap.remove(maxKey);
            nums[i] = max;
        }
        return nums;
    }


}

