package com.data.tructure.array.算法.leetcode.a1两个总和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuishifeng
 * @date 2019-05-30
 */
public class Demo {


    @Test
    public void test() throws Exception {
        int[] nums = {1, 5, 2, 4, 6, 0, 8, 3};
        List<String> list = toSum(nums, 6);
        for (String str : list) {
            System.out.println(str);
        }
    }


    public List<String> toSum(int[] nums, int sum) {
        List<String> str = new ArrayList<>();
        if (nums == null) {
            return str;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(sum - nums[i]) != null) {
                str.add(map.get(sum - nums[i]) + " - " + nums[i]);
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return str;
    }

}
