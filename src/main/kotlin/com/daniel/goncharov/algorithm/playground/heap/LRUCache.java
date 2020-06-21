package com.daniel.goncharov.algorithm.playground.heap;

import java.util.HashMap;
import java.util.Objects;

public class LRUCache {

    private final int capacity;
    private final HashMap<Integer, Node> nodeHashMap;

    private int currentSize;
    private Node head;//todo assignment
    private Node tail;//todo assignment

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeHashMap = new HashMap(capacity);
        currentSize = 0;
    }

    public void set(int key, int value) {
        if (nodeHashMap.containsKey(key)) {
            Node node = nodeHashMap.get(key);
            addToTop(node);
            return;
        }

        Node node = new Node(value);
        if (currentSize == capacity) {
            removeLast();
        } else {
            currentSize++;
        }
        addToTop(node);
        nodeHashMap.put(key, node);

    }

    public int get(int key) {
        if (!nodeHashMap.containsKey(key)) return -1;
        Node node = nodeHashMap.get(key);
        addToTop(node);
        return node.value;

    }

    private void removeLast() {
        Node previous = tail.previous;
        if (capacity == 1) {
            tail = null;
            head = null;
            return;
        } else if (previous != null) {
            previous.next = null;
            tail = previous;
        }
    }

    private void addToTop(Node node) {
        if (head == null && tail == null) {//very first item
            head = node;
            tail = node;
            return;
        }
        if (node == head) return; // already on top
        //remove from chain
        Node previous = node.previous;
        Node next = node.next;
        if (previous != null) {
            previous.next = next;
        }

        if (node == tail && previous != null) {
            tail = previous;
        }

        //add to top of the chain
        node.previous = null;
        node.next = head;
        head = node;
    }

    private static class Node {
        final int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
