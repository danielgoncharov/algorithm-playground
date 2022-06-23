package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

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
}
