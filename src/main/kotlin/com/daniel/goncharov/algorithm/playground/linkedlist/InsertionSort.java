package com.daniel.goncharov.algorithm.playground.linkedlist;

public class InsertionSort {

    public ListNode insertionSortList(ListNode input) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = input;
        ListNode current = input.next;
        ListNode previous = input;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            if (current.val >= previous.val) {
                previous = current;
            } else {
                previous.next = next;
                insert(head, current);
            }
            current = next;
        }
        return head.next;
    }

    private void insert(ListNode head, ListNode current) {
        ListNode left = head;
        ListNode right = head.next;
        while (left.val > current.val || current.val > right.val) {
            left = right;
            right = right.next;
        }
        left.next = current;
        current.next = right;
    }
}
