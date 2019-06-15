package com.data.tructure.array.算法.链表.合并链表;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-12
 */
public class LinkedMerge {


    public Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node head = null;
        if (node1.val <= node2.val) {
            head = node1;
            head.next = merge(node1.next, node2);
        } else {
            head = node2;
            head.next = merge(node1, node2.next);
        }
        return head;
    }

    @Test
    public void test() throws Exception {

        // 1->3->7   5->6->8
        Node oneNode3 = new Node(7, null);
        Node oneNode2 = new Node(3, oneNode3);
        Node oneNode1 = new Node(1, oneNode2);

        Node tNode3 = new Node(8, null);
        Node tNode2 = new Node(6, tNode3);
        Node tNode1 = new Node(5, tNode2);

//        Node head = merge(oneNode1, tNode1);
//        list(head);

//        Node head = mergeNode(oneNode1, tNode1);
//        System.out.println("");
//        Node.nodePrint(head);

        Node head = mergeNode2(oneNode1, tNode1);
        Node.nodePrint(head);
    }

    /**
     * 递归
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node mergeNode(Node head1, Node head2) {

        // 1->3->7  5->6->8

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head = null;
        // 递归思路
        // 1 和 5 比较 选出    1
        // 1和 5 比较选出 3
        // 7和5比较 选出 5
        // 7和6比较 选出 6
        // 7和8比较 选出 7
        // 剩下 返回 8
        if (head1.val <= head2.val) {
            head = head1;
            head.next = mergeNode(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeNode(head1, head2.next);
        }
        return head;
    }

    /**
     * 循环
     *
     * @param node1
     * @param node2
     * @return
     */
    public Node mergeNode2(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node head = null;
        Node cur = null;
        Node temp = null;

        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                temp = node1;
                node1 = node1.next;
            } else {
                temp = node2;
                node2 = node2.next;
            }
            if (cur == null) {
                cur = temp;
                head = cur;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        cur.next = node1 == null ? node2 : node1;
        return head;
    }









    public void list(Node node) {
        System.out.print(node.val + " ");
        if (node.next != null) {
            list(node.next);
        }
    }


    public Node merge2(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node head = null;
        if (node1.val <= node2.val) {
            head = node1;
            head.next = merge2(node1.next, node2);
        } else {
            head = node2;
            head.next = merge2(node1, node2.next);
        }
        return head;
    }


}
