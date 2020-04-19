package com.data.tructure.array.算法.leetcode.a2两数相加;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

public class Test20200419 {


    @Test
    public void test() throws Exception {



    }

    public Node twoAddSum(Node l1, Node l2) {

        int sum = 0;
        int pre = 0;
        Node node = new Node(0);
        Node cur1 = l1, cur2 = l2, curr = node;

        while (cur1 != null || cur2 != null) {
            int l = cur1 != null ? cur1.val : 0;
            int r = cur2 != null ? cur2.val : 0;
            int add = l + r + pre;
            curr.next = new Node(add % 10);
            sum = add % 10 + sum * 10;
            if (add / 10 == 1) {
                pre = 1;
            }
            curr = curr.next;
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }
        return node.next;

    }

}
