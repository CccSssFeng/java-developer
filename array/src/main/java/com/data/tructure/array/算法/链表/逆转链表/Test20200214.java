package com.data.tructure.array.算法.链表.逆转链表;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

public class Test20200214 {

    @Test
    public void test() throws Exception {
        Node.nodePrint(Node.getNode());
        Node backNode = getBackNode(Node.getNode());
        System.out.println("");
        Node.nodePrint(backNode);
    }

    public Node getBackNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = getBackNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
