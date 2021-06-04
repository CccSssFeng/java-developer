package com.data.tructure.array.算法.二叉树.最大值;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

public class Test20200215 {

    @Test
    public void test() throws Exception {
        System.out.println(getMaxValue(BinaryTreeNode.getTreeNode()));
    }

    public int getMaxValue(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int rootMax = treeNode.data;
        int leftMax = getMaxValue(treeNode.left);
        int rightMax = getMaxValue(treeNode.right);
        int max = leftMax > rightMax ? leftMax : rightMax;
        return max > rootMax ? max : rootMax;
    }
}
