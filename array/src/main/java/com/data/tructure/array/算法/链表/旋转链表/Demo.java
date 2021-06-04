package com.data.tructure.array.算法.链表.旋转链表;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-26
 */
public class Demo {


    @Test
    public void test() throws Exception {
        Node rotate = rotate(Node.getNode(), 2);
        Node.nodePrint(rotate);
    }

    // 1->2->3->4->5

    /*
     * 这个结果是错误的
     */
    @Deprecated
    public Node rotate(Node head, int index) {
        if (head == null || head.next == null || index <= 0) {
            return head;
        }
        Node temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        System.out.println("len: " + len);
        if (len < index) {
            return head;
        }
        temp.next = head;
        int i = 1;
        while (i != index) {
            i++;
            head = head.next;
        }
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }
}
