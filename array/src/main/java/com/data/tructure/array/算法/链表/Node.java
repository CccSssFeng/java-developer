package com.data.tructure.array.算法.链表;

/**
 * @author cuishifeng
 * @date 2019-04-15
 */
public class Node {

    public int val;
    public Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node getNode() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        return node1;
    }

    public static void nodePrint(Node head) {
        if (head != null) {
            System.out.print(head.val + " ");
            nodePrint(head.next);
        }
    }
}
