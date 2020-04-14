package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

import java.util.Stack;

public class Test20200414 {

    @Test
    public void test() throws Exception {
//        backOrder(BinaryTreeNode.getTreeNode());
//        System.out.println(getHight(BinaryTreeNode.getTreeNode()));
//        System.out.println(getNodeNum(BinaryTreeNode.getTreeNode()));
//        preOrder(BinaryTreeNode.getTreeNode());
        centerOrder(BinaryTreeNode.getTreeNode());
    }

    public void backOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        BinaryTreeNode pre = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.empty()) {
                cur = stack.peek();
                if (cur.right == null || cur.right == pre) {
                    BinaryTreeNode node = stack.pop();
                    System.out.println(node.data);
                    pre = node;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }
    }

    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTreeNode node = stack.pop();
            if (node != null) {
                System.out.println(node.data);
                if (node.right != null)
                    stack.add(node.right);
                if (node.left != null)
                    stack.add(node.left);
            }
        }
    }

    public void centerOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur != null) {
                System.out.println(cur.data);
                cur = cur.right;
            }
        }
    }

    public int getHight(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHight(root.left) + 1;
        int right = getHight(root.right) + 1;
        return left > right ? left : right;
    }

    public int getNodeNum(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeNum(root.left) + getNodeNum(root.right) + 1;
    }
}
