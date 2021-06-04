package com.data.tructure.array.算法.二叉树.二叉树最小深度;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-30
 */
public class Demo {

    @Test
    public void test() throws Exception {
        int minDepth = minDepth(BinaryTreeNode.getTreeNode());
        System.out.println(minDepth);
    }

    public int minDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = minDepth(node.getLeft());
        int right = minDepth(node.getRight());
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
