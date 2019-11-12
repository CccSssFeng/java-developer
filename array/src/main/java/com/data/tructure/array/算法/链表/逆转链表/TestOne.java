package com.data.tructure.array.算法.链表.逆转链表;


import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-05-07
 */
public class TestOne {


    public Node get(Node node) {

        if (node == null) {
            return node;
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

    @Test
    public void test() throws Exception {
        Node node = get(Node.getNode());
        Node.nodePrint(node);
    }


    public Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 1 2 3 4
        Node node = reverseNode(head.next);
        // 展示顺序 head 4 3 2 1

        // 第一轮：
        // 当前指向顺序 4 -> 5

        head.next.next = head; // 变成了 5 -> 4 但是4的指针仍然指向5 也就是双向的
        // 所以 4 -> null 变成单向
        head.next = null;

        // node是最后一个元素 5 也就是逆转后的 第一个元素
        return node;
    }

    @Test
    public void test3() throws Exception {
        Node node = reverseNode(Node.getNode());
        Node.nodePrint(node);
    }


}
