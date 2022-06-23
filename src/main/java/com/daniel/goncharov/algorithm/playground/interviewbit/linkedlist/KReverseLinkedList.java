package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode input, int reverseInterval) {
        if (reverseInterval == 1) return input;
        ListNode head = new ListNode(0);
        ListNode previous = null;
        ListNode current = input;
        ListNode next = input.next;
        ListNode intervalHead = null;
        ListNode intervalTail = null;
        int index = 1;
        while (current != null) {
            if (isTail(reverseInterval, index)) {
                if (intervalTail != null) {
                    intervalHead = intervalTail;
                }
                intervalTail = current;
            }
            if (isHead(reverseInterval, index)) {
                if (intervalHead != null) {
                    intervalHead.next = current;
                }
                intervalHead = current;
            }
            if (isHead(reverseInterval, index) && head.next == null) {
                head.next = current;
            }

            current.next = previous;
            previous = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
            index++;

        }
        intervalTail.next = null;
        return head.next;
    }

    private boolean isHead(int reverseInterval, int index) {
        return index % reverseInterval == 0;
    }

    private boolean isTail(int reverseInterval, int index) {
        return index % reverseInterval == 1;
    }
}
