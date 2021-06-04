package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

import java.util.Stack;

public class Test20200214 {

    @Test
    public void test() throws Exception {
        //        先序遍历
        //        first(BinaryTreeNode.getTreeNode());
        //        中序遍历
        //        center(BinaryTreeNode.getTreeNode());
        //        后序遍历
        //        tail((BinaryTreeNode.getTreeNode()));
        //        非递归先序遍历
        //        first2(BinaryTreeNode.getTreeNode());
        //        center2(BinaryTreeNode.getTreeNode());
        after2(BinaryTreeNode.getTreeNode());
    }

    /**
     * 先序遍历
     */
    public void first(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            first(root.left);
            first(root.right);
        }
    }

    /**
     * 中序遍历
     */
    public void center(BinaryTreeNode root) {
        if (root != null) {
            center(root.left);
            System.out.println(root.data);
            center(root.right);
        }
    }

    /**
     * 后序遍历
     */
    public void tail(BinaryTreeNode root) {
        if (root != null) {
            tail(root.left);
            tail(root.right);
            System.out.println(root.data);
        }
    }

    public void first2(BinaryTreeNode root) {
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    System.out.println(root.data);
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop().right;
                }
            }
        }
    }

    public void center2(BinaryTreeNode root) {
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    BinaryTreeNode left = stack.pop();
                    System.out.println(left.data);
                    root = left.right;
                }
            }
        }
    }

    public void after2(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();

        }

    }


}
