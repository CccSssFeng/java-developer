package com.data.tructure.array.算法.二叉树.k层节点个数;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

public class Test20200413 {

    @Test
    public void test() throws Exception {

        System.out.println(getNumOfLevelNode(BinaryTreeNode.getTreeNode(), 4));
    }

    public int getNumOfLevelNode(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int left = getNumOfLevelNode(root.left, k - 1);
        int right = getNumOfLevelNode(root.right, k - 1);
        return left + right;
    }
}
