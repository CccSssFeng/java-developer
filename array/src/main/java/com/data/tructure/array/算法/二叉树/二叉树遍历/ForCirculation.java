package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author cuishifeng
 * @date 2019-04-30
 */
public class ForCirculation {


    @Test
    public void test() throws Exception {
        preorderTraversal(BinaryTreeNode.getTreeNode());
    }

    public void preorderTraversal(BinaryTreeNode node) {

        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            System.out.println(pop.data);
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
        }
    }
}
