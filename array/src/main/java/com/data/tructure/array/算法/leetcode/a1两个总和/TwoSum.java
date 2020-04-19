package com.data.tructure.array.算法.leetcode.a1两个总和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuishifeng
 * @date 2019-05-09
 */
public class TwoSum {


    public List<String> sum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        List<String> results = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                results.add(nums[value] + "," + nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return results;
    }


    public List<String> twoSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<String> st = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                st.add(map.get(sum - arr[i]) + "," + arr[i]);
            } else {
                map.put(arr[i], arr[i]);
            }
        }
        return st;
    }


    public List<String> twoSum2(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] + arr[j] == sum) {
                    list.add(arr[i] + "," + arr[j]);
                }
            }
        }
        return list;
    }

    @Test
    public void test() throws Exception {
        int[] arr = {1, 5, 2, 4, 6, 0, 8, 3};
        List<String> sum = twoSum2(arr, 6);
        sum.stream().forEach(System.out::println);
    }

}
