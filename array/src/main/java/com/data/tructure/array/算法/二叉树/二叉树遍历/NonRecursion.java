package com.data.tructure.array.算法.二叉树.二叉树遍历;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author cuishifeng
 * @date 2019-05-31
 */
public class NonRecursion {


    /**
     * 前序遍历 - 非递归
     */
    public List<Integer> preTraverseTree(BinaryTreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                list.add(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return list;
    }

    /**
     * 中序遍历 - 非递归
     */
    public List<Integer> centerTraverseTree(BinaryTreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                list.add(treeNode.data);
                treeNode = treeNode.right;
            }
        }
        return list;
    }

    public void center(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            center(treeNode.left);
            System.out.println(treeNode.data);
            center(treeNode.right);
        }
    }


    public LinkedList<Integer> afterTraverseTree(BinaryTreeNode treeNode) {
        LinkedList<Integer> list = new LinkedList<>();
        if (treeNode == null) {
            return list;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                list.addFirst(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.right;
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.left;
            }
        }
        return list;
    }

    public void after(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            after(treeNode.left);
            after(treeNode.right);
            System.out.print(treeNode.data + ",");
        }
    }


    @Test
    public void test() throws Exception {
        after(BinaryTreeNode.getTreeNode());
    }


    @Test
    public void test3() throws Exception {
        //        center(BinaryTreeNode.getTreeNode());
        List<Integer> list = centerTraverseTree(BinaryTreeNode.getTreeNode());
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test4() throws Exception {
        after(BinaryTreeNode.getTreeNode());
        System.out.println("");
        System.out.println("=======================");
        LinkedList<Integer> linkedList = afterTraverseTree(BinaryTreeNode.getTreeNode());
        for (Integer value : linkedList) {
            System.out.print(value + ",");
        }
    }


    @Test
    public void test2() throws Exception {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
        }

    }


}
