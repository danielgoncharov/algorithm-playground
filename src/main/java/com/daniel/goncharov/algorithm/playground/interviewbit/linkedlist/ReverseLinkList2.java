package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class ReverseLinkList2 {

    public ListNode reverseBetween(ListNode input, int m, int n) {
        int leftIndex = m - 1;
        int rightIndex = n - 1;
        int index = 0;
        ListNode lastOfHead = null;
        ListNode previous = null;
        ListNode current = input;
        ListNode next;
        ListNode lastReversed = null;
        while (index <= rightIndex) {
            if (index == leftIndex) {
                lastReversed = current;
            }
            if (index == leftIndex - 1) {
                lastOfHead = current;
                current = current.next;
            } else if (index >= leftIndex && index <= rightIndex) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            } else {
                current = current.next;
            }
            index++;
        }
        lastReversed.next = current;
        if (leftIndex == 0) {
            return previous;
        } else {
            lastOfHead.next = previous;
            return input;
        }
    }
}
