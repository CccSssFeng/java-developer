package com.data.tructure.array.算法.链表.删除重复节点;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuishifeng
 * @date 2019-05-05
 */
public class Demo {

    private static AtomicInteger count = new AtomicInteger(1);

    @Test
    public void test() throws Exception {
        Node node8 = new Node(3, null);
        Node node7 = new Node(3, node8);
        Node node6 = new Node(7, node7);
        Node node5 = new Node(2, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        // 1 -> 2 -> 3 -> 4 -> 2 -> 7 -> 3 -> 3
        Node.nodePrint(node1);
        System.out.println("");
        deleteExisNode(node1);
        Node.nodePrint(node1);
    }

    public Node deleteExisNode(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node pre = cur;
        HashSet set = new HashSet();
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
