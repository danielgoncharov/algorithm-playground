package com.daniel.goncharov.algorithm.playground.linkedlist;

public class PartitionList {

    public ListNode partition(ListNode input, int pivot) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode currentNode = input;
        ListNode currentLess = less;
        ListNode currentMore = more;
        while (currentNode != null) {
            if (currentNode.val < pivot) {
                currentLess.next = currentNode;
                currentLess = currentNode;
            } else {
                currentMore.next = currentNode;
                currentMore = currentNode;
            }
            ListNode next = currentNode.next;
            currentNode.next = null;
            currentNode = next;
        }
        currentLess.next = more.next;
        return less.next;
    }
}
