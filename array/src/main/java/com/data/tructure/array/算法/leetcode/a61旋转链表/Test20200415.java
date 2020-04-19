package com.data.tructure.array.算法.leetcode.a61旋转链表;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

public class Test20200415 {

    @Test
    public void test() throws Exception {
        Node.nodePrint(rotate(Node.getNode(), 2));
    }

    public Node rotate(Node head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        Node temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;
        Node newTail = head;
        for (int i = 0; i < (len - k % len - 1); i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

}
