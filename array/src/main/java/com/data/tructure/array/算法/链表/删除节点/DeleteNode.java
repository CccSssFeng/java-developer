package com.data.tructure.array.算法.链表.删除节点;

import com.data.tructure.array.算法.链表.Node;
import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-15
 */
public class DeleteNode {

    public Node deleteNode(Node head, Node deleteNode) {

        if (deleteNode == null || head == null) {
            return head;
        }
        // 1. 等于头结点
        if (head == deleteNode) {
            return head.next;
        }
        // 2. 尾部节点
        if (deleteNode.next == null) {
            Node temp = head;
            while (temp.next != deleteNode) {
                temp = temp.next;
            }
            temp.next = null;
        }
        // 3. 在中间某个节点
        else {
            deleteNode.val = deleteNode.next.val;
            deleteNode.next = deleteNode.next.next;
        }
        return head;
    }

    @Test
    public void test() throws Exception {
        // 1->3->7->9->12
        Node oneNode5 = new Node(5, null);
        Node oneNode4 = new Node(4, oneNode5);
        Node oneNode3 = new Node(3, oneNode4);
        Node oneNode2 = new Node(2, oneNode3);
        Node oneNode1 = new Node(1, oneNode2);

        Node node = deleteNode(oneNode1, oneNode5);
        translate(node);

    }

    public void translate(Node node) {
        System.out.print(node.val + " ");
        if (node.next != null) {
            translate(node.next);
        }
    }

    public Node delete(Node head, Node deleteNode) {
        if (head == null || deleteNode == null) {
            return null;
        }
        if (head == deleteNode) {
            Node temp = head.next;
            return temp;
        }
        if (deleteNode.next != null) {
            deleteNode.val = deleteNode.next.val;
            deleteNode.next = deleteNode.next.next;
            return head;
        } else {
            while (head != null) {
                if (head.next == deleteNode) {
                    head.next = null;
                }
            }
            return head;
        }
    }

    @Test
    public void test9() throws Exception {
        Node head = Node.getNode();
        Node delete = delete(head, head.next);
        Node.nodePrint(delete);
    }

}
