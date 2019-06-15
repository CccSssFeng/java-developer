package com.data.tructure.array.算法.二叉树.二叉树最大层数;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-28
 */
public class Demo {

    @Test
    public void test() throws Exception {
        System.out.println(getTreeMaxLevel(BinaryTreeNode.getTreeNode()));
    }

    public int getTreeMaxLevel(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getTreeMaxLevel(treeNode.getLeft()), getTreeMaxLevel(treeNode.getRight())) + 1;
    }
}
