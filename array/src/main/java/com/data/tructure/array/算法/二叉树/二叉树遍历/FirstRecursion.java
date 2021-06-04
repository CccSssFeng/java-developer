package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-30
 */
public class FirstRecursion {


    @Test
    public void test() throws Exception {
        first(BinaryTreeNode.getTreeNode());
    }


    public void first(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.data);
            first(node.left);
            first(node.right);
        }
    }


}
