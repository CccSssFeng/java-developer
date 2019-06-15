package com.data.tructure.array.算法.链表.逆转链表;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-25
 */
public class Demo {

    @Test
    public void test() throws Exception {
        // 1->2->3->4->5->null
        Node reverse = reverse(Node.getNode());
        Node.nodePrint(reverse);
        // 5->4->3->2->1
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 取前面节点
        Node pre = head;
        // 取后面节点
        Node cur = head.next;
        // 临时节点
        Node temp = null;
        while (cur != null) {
            // 1. 保存后节点的指向节点 因为要替换后节点的指向节点为他的前节点
            temp = cur.next;
            // 2. 把后节点的指向的节点替换成前节点
            cur.next = pre;

            // 下一轮要替换的前节点和后节点
            // 第一次 pre = 1 cur =2  || 那第二次 就得 pre = 2 cur = 3
            pre = cur;
            cur = temp;
        }
        // 在上述过程中未替换首节点的指向节点　这里首节点将成为尾节点　所以指向null
        head.next = null;
        // 因为循环的条件是cur是否为null 如果cur为null 那 pre将是原来链表的尾节点
        // 就是逆转后的首节点
        return pre;
    }

}
