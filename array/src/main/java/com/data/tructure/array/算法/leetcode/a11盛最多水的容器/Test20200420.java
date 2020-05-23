package com.data.tructure.array.算法.leetcode.a11盛最多水的容器;

import org.junit.Test;

public class Test20200420 {

    @Test
    public void test() throws Exception {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
     * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
     */


    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int left = height[start];
            int right = height[end];
            int hei = Math.min(left, right);
            int area = hei * (end - start);
            maxArea = Math.max(maxArea, area);
            if (left > right) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;
    }
}
