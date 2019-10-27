package com.daniel.goncharov.algorithm.playground.linkedlist;

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode input) {
        ListNode currentNode = input;
        ListNode pointer = input.next;
        while (pointer != null) {
            if (currentNode.val != pointer.val) {
                currentNode.next = pointer;
                currentNode = pointer;
            }
            pointer = pointer.next;
        }
        currentNode.next = null;
        return input;
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
