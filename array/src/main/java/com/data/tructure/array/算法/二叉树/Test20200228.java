package com.data.tructure.array.算法.二叉树;

import org.junit.Test;

public class Test20200228 {

    @Test
    public void test() throws Exception {

        System.out.println(maxDepth(BinaryTreeNode.getTreeNode()));
        System.out.println(nodeNum(BinaryTreeNode.getTreeNode()));
        System.out.println(maxNode(BinaryTreeNode.getTreeNode()));
    }

    public int maxDepth(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        int max = left;
        if (max < right)
            max = right;
        return max + 1;
    }

    public int nodeNum(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = nodeNum(treeNode.left);
        int right = nodeNum(treeNode.right);
        return left + right + 1;
    }

    public int maxNode(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return -1;
        int value = treeNode.data;
        int left = maxNode(treeNode.left);
        int right = maxNode(treeNode.right);
        int max = value;
        if (max < left)
            max = left;
        if (max < right)
            max = right;
        return max;
    }

}
