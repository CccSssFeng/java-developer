package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackOrder {


    @Test
    public void test() throws Exception {
        //        preSort(BinaryTreeNode.getTreeNode());
        //        List<Integer> list = preOrder(BinaryTreeNode.getTreeNode());
        //        centerOrder(BinaryTreeNode.getTreeNode());
        //        List<Integer> list = centerOrder2(BinaryTreeNode.getTreeNode());
        //        backOrder(BinaryTreeNode.getTreeNode());
        List<Integer> list = backOrder2(BinaryTreeNode.getTreeNode());
        list.stream().forEach(System.out::println);
    }


    public void preSort(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        System.out.println(binaryTreeNode.data);
        preSort(binaryTreeNode.left);
        preSort(binaryTreeNode.right);
    }

    public List<Integer> preOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTreeNode node = stack.pop();
            if (node != null) {
                list.add(node.data);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

    public void centerOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        centerOrder(root.left);
        System.out.println(root.data);
        centerOrder(root.right);
    }

    public List<Integer> centerOrder2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        while (!stack.empty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.data);
            current = current.right;
        }
        return list;
    }

    public void backOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        backOrder(root.left);
        backOrder(root.right);
        System.out.println(root.data);
    }

    public List<Integer> backOrder2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BinaryTreeNode current = root;
        BinaryTreeNode pre = null;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            if (!stack.empty()) {
                current = stack.peek();
                if (current.right == null || current.right == pre) {
                    BinaryTreeNode node = stack.pop();
                    list.add(node.data);
                    pre = node;
                    current = null;
                } else {
                    current = current.right;
                }
            }
        }
        return list;
    }

    @Test
    public void stackTest() throws Exception {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.push(4);
        System.out.println(stack.peek());

        //        while (!stack.empty()) {
        //
        //        }
    }
}
