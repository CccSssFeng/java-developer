package com.data.tructure.array.算法.递归.翻转单向链表;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

public class Test20200215 {

    /*
     * 1->2->3->4->null
     * 4->3->2->1->null
     */
    public Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    @Test
    public void test() throws Exception {
        Node.nodePrint(reverseNode(Node.getNode()));
    }
}
