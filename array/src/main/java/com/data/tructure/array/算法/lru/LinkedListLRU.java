package com.data.tructure.array.算法.lru;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListLRU {


    private LinkedList<Node> list;

    private int size;

    public LinkedListLRU(int size) {
        list = new LinkedList<>();
        this.size = size;
    }

    public int getValue(int key) {
        int result = -1;
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                result = node.value;
                iterator.remove();
                put(node.key, node.value);
                break;
            }
        }
        return result;
    }

    public void put(int key, int value) {
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }
        if (list.size() == this.size) {
            list.removeFirst();
        }

        this.list.add(new Node(key, value));
    }

    public void iterator() {
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            System.out.println("[" + node.key + "," + node.value + "]");
        }
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // https://www.jianshu.com/p/ec1952b9d84a

        LinkedListLRU listLRU = new LinkedListLRU(3);
        listLRU.put(1, 1);
        listLRU.put(2, 2);
        listLRU.put(3, 3);
        listLRU.put(4, 4);

        listLRU.iterator();
        System.out.println("-------------------");

        System.out.println(listLRU.getValue(3));

        System.out.println("-------------------");
        listLRU.iterator();

        listLRU.put(6, 6);
        System.out.println("-------------------");
        listLRU.iterator();


        LinkedList linkedList = new LinkedList();
    }

}
