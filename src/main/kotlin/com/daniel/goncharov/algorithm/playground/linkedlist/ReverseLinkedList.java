package com.daniel.goncharov.algorithm.playground.linkedlist;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode node) {
        ListNode previousNode = null;
        ListNode nextNode;
        do {
            ListNode currentNode = node;
            nextNode = node.next;
            node.next = previousNode;
            previousNode = currentNode;
            node = nextNode;
        } while (nextNode != null);
        return previousNode;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
