package com.data.tructure.array.算法.链表.逆转链表;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

public class Test20200305 {

    /*
     * 1 -> 2 -> 3 -> null
     */

    @Test
    public void test() throws Exception {
//        Node node = getNode(Node.getNode());
//        Node.nodePrint(node);

        Node.nodePrint(reverseNode(Node.getNode()));
    }

    public Node getNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = getNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
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
