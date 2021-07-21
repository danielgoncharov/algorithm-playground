package com.daniel.goncharov.algorithm.playground.backtracking;

import com.daniel.goncharov.algorithm.playground.linkedlist.ListNode;

public class ReverseLinkListRecursion {
    public ListNode reverseList(ListNode list) {
        ListNode pointerToFirst = new ListNode(0);
        reverse(null, list, pointerToFirst);
        return pointerToFirst.next;
    }

    private void reverse(ListNode previous, ListNode current, ListNode pointerToFirst) {
        if (current.next == null) {
            current.next = previous;
            pointerToFirst.next = current;
        } else {
            reverse(current, current.next, pointerToFirst);
            current.next = previous;
        }
    }
}
