package com.data.tructure.array.算法.lru;

/**
 * 自己实现双向链表然后实现LRU
 */
public class MyLinkedListLRU {


    static class LinkedList<E> {

        private Node<E> head;
        private Node<E> tail;

        private int size = 0;

        public LinkedList() {

        }

        public synchronized void add(E e) {
            if (this.head == null) {
                Node node = new Node<>(e, null, null);
                this.head = node;
                this.tail = this.head;
            } else {
                Node node = new Node<>(e, this.tail, null);
                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;
            }
            size++;
        }

        public synchronized boolean remove(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return false;
            }
            if (size == 1) {
                this.head = null;
                size--;
                return true;
            }
            if (index == 0) {
                this.head = this.head.next;
                this.head.pre = null;
                size--;
                return true;
            }
            if (index == size - 1) {
                this.tail = this.tail.pre;
                this.tail.next = null;
                size--;
                return true;
            }
            int len = index;
            Node<E> node = this.tail;
            if ((len = size - index - 1) > index) {
                node = this.head;
            }
            for (int i = 0; i < len; i++) {
                if (node == this.head) {
                    node = node.next;
                } else {
                    node = node.pre;
                }
            }
            if (node != null) {
                Node h = node.pre;
                Node l = node.next;
                h.next = l;
                l.pre = h;
                size--;
                return true;
            }
            return false;
        }

        class Node<E> {
            E item;
            Node<E> pre;
            Node<E> next;

            public Node(E item, Node<E> pre, Node<E> next) {
                this.item = item;
                this.pre = pre;
                this.next = next;
            }
        }


    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.remove(3);
    }


}
