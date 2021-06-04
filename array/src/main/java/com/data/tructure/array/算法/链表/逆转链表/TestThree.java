package com.data.tructure.array.算法.链表.逆转链表;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

public class TestThree {


    @Test
    public void test() throws Exception {

        Node node = Node.getNode();
        Node.nodePrint(reversion(node));

    }

    private Node reversion(Node node) {

        if (node == null) {
            return null;
        }

        Node pre = node;
        Node cur = node.next;

        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        node.next = null;
        return pre;
    }

}
