package com.data.tructure.array.算法.递归;

import org.junit.Test;

public class Test20200214 {

    /*
     * 递归就是 每个步骤暂存在栈里 最后返回的时候把每个步骤倒序执行一遍
     * 1. 结束条件
     * 2. 等价函数
     *
     * 二叉树中运用递归非常多
     */

    @Test
    public void test() throws Exception {
        System.out.println(add(10));
    }

    public int add(int num) {
        if (num <= 0) {
            return 0;
        }
        int i = num + add(num - 1);
        return i;
    }

}
