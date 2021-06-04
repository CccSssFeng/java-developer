package com.data.tructure.array.算法.链表.判断链表是否有环;

import com.data.tructure.array.算法.链表.Node;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author cuishifeng
 * @date 2019-05-05
 */
public class Demo {


    @Test
    public void test() throws Exception {
        Node head = Node.getNode();
        builderLoop(head);
        System.out.println(isLoop(head));
        System.out.println(fastSlowLoop(Node.getNode()));
    }

    /**
     * 快慢指针
     */
    public boolean fastSlowLoop(Node node) {
        if (node == null) {
            return false;
        }
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据hashSet长度变化判断是否有环
     */
    public boolean isLoop(Node node) {
        if (node == null) {
            return false;
        }
        int count = 0;
        HashSet set = new HashSet();
        while (node != null) {
            set.add(node);
            count++;
            if (count > set.size()) {
                return true;
            }
            node = node.next;
        }
        return false;
    }


    public void builderLoop(Node node) {
        Node cur = null;
        while (node.next != null) {
            if (node.val == 3) {
                cur = node;
            }
            node = node.next;
        }
        node.next = cur;
    }
}
