package com.data.tructure.array.算法.剑指Offer.三数组中重复数字;

import org.junit.Test;

import java.util.HashMap;

public class Test20200311 {

    /*
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     *
     * 还需要咨询面试官 空间和时间的要求 比如要求时间快 空间不关心等 可以用hash
     */

    /**
     * 使用hash字典查找
     * 时间复杂度 O(n) 空间复杂度 O(n)
     */
    public int findRepeatNum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i] + "")) {
                return nums[i];
            }
            hashMap.put(nums[i] + "", nums[i]);
        }
        return -1;
    }

    /**
     * 时间和空间复杂度 都是 O(n)
     * 但是比hash表空间使用少  hashMap 默认就要开辟 16 长度的数组
     * 达到阈值 还要扩容 数据结构对象也多
     */
    public int findRepeatNum2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        // 使用这个的关键是题目中说的 数组 nums 里的所有数字都在数组长度 0～n-1 的范围内
        int[] arrays = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arrays[nums[i]]++;
            if (arrays[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }


    @Test
    public void test() throws Exception {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        //        System.out.println(findRepeatNum(array));
        System.out.println(findRepeatNum2(array));
    }
}
