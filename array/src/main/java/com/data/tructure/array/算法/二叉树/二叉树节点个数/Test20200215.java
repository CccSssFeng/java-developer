package com.data.tructure.array.算法.二叉树.二叉树节点个数;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

public class Test20200215 {

    @Test
    public void test() throws Exception {
        System.out.println(getSumTotal(BinaryTreeNode.getTreeNode()));
        BinaryTreeNode.preOrder(BinaryTreeNode.getTreeNode());
    }

    public int getSumTotal(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getSumTotal(treeNode.left);
        int right = getSumTotal(treeNode.right);
        return left + right + 1;
    }
}
