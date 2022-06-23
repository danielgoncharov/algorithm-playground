package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class PalindromeList {

    public int lPalin(ListNode input) {
        int size = getSize(input);
        int fromLeft = size / 2;
        ListNode left = input;
        ListNode right = revert(move(input, fromLeft));
        while (right != null) {
            if (left.val != right.val) {
                return 0;
            }
            left = left.next;
            right = right.next;

        }
        return 1;
    }

    private ListNode revert(ListNode node) {
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

    private ListNode move(ListNode input, int move) {
        while (move != 0) {
            input = input.next;
            move--;
        }
        return input;
    }

    private int getSize(ListNode input) {
        int size = 0;
        do {
            size++;
            input = input.next;
        } while (input != null);
        return size;
    }

}
