package com.data.tructure.array.算法.二叉树.二叉树最小深度;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

public class Test20200215 {

    @Test
    public void test() throws Exception {
        System.out.println(getMinHeight(BinaryTreeNode.getTreeNode()));
    }

    public int getMinHeight(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getMinHeight(treeNode.left);
        int right = getMinHeight(treeNode.right);
        return left < right ? left + 1 : right + 1;
    }
}
