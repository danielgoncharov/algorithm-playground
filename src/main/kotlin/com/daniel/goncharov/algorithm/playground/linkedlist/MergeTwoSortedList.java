package com.daniel.goncharov.algorithm.playground.linkedlist;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode listA, ListNode listB) {
        final ListNode head =  new ListNode(0);
        ListNode prev = head;
        while (listA != null || listB != null) {
            boolean moveA = listB == null || (listA != null && listA.val <= listB.val);
            if (moveA) {
                prev.next = listA;
                listA = listA.next;
            } else {
                prev.next = listB;
                listB = listB.next;
            }
            prev = prev.next;
            prev.next = null;
        }
        return head.next;
    }
}
