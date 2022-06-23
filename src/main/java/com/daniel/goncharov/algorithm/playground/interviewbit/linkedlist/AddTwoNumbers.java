package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode top, ListNode bottom) {
        ListNode head = new ListNode(0);
        int overflow = 0;
        ListNode previous = null;
        while (top != null || bottom != null) {
            int valueTop = getValue(top);
            int valueBottom = getValue(bottom);
            int sum = valueTop + valueBottom + overflow;
            overflow = 0;
            if (sum >= 10) {
                overflow = 1;
                sum = sum % 10;
            }
            ListNode current = new ListNode(sum);
            if (previous == null) {
                head.next = current;
            } else {
                previous.next = current;
            }
            previous = current;
            if (top != null) {
                top = top.next;
            }
            if (bottom != null) {
                bottom = bottom.next;
            }
        }
        if (overflow == 1) {
            previous.next = new ListNode(overflow);
        }
        return head.next;
    }

    private int getValue(ListNode node) {
        if (node == null) return 0;
        else return node.val;
    }

}
