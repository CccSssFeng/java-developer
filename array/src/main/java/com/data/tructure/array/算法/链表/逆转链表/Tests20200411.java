package com.data.tructure.array.算法.链表.逆转链表;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

public class Tests20200411 {

    @Test
    public void test() throws Exception {

        Node.nodePrint(reverseNode2(Node.getNode()));
    }


    public Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public Node reverseNode2(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head.next;
        Node pre = head;
        Node temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }
}
