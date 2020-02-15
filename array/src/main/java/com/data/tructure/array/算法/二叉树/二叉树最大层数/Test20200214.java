package com.data.tructure.array.算法.二叉树.二叉树最大层数;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

public class Test20200214 {


    @Test
    public void test() throws Exception {
//        System.out.println(getTreeHeight(BinaryTreeNode.getTreeNode()));
        System.out.println(getHeightLeft(BinaryTreeNode.getTreeNode()));
    }

    public int getTreeHeight(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getTreeHeight(treeNode.left);
        int right = getTreeHeight(treeNode.right);
        return left > right ? left + 1 : right + 1;
    }

    public int getHeightLeft(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int treeHeight = getHeightLeft(node.left);
        return treeHeight + 1;
    }
}
