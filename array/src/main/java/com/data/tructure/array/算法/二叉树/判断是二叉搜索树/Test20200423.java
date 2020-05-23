package com.data.tructure.array.算法.二叉树.判断是二叉搜索树;

import com.data.tructure.array.算法.二叉树.BinaryTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test20200423 {

    @Test
    public void test() throws Exception {

        System.out.println(isValidBST(BinaryTreeNode.getTreeNode()));
    }


    public boolean isBst(BinaryTreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if ((min != null && min > treeNode.data) || (max != null && max < treeNode.data)) {
            return false;
        }
        return false;
    }
    public static boolean flag = true;
    public boolean isValidBST(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        isBST(root, new ArrayList<>(), flag);
        return flag;
    }

    public void isBST(BinaryTreeNode treeNode, List<Integer> list, boolean flag) {
        if (treeNode != null) {
            isBST(treeNode.left, list, flag);
            if (flag && list.size() > 0 && treeNode.data < list.get(list.size() - 1)) {
                flag = false;
            }
            list.add(treeNode.data);
            isBST(treeNode.right, list, flag);
        }
    }
}
