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


}
