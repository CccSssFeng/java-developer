package com.data.tructure.array.算法.二叉树.二叉树节点个数;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-28
 */
public class Demo {

    @Test
    public void test() throws Exception {
        System.out.println(getNodeNum(BinaryTreeNode.getTreeNode()));
    }

    public int getNodeNum(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return 0;
        }
        return getNodeNum(binaryTreeNode.getLeft()) + getNodeNum(binaryTreeNode.getRight()) + 1;
    }
}
