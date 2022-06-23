package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class ReorderList {

    public ListNode reorderList(ListNode input) {
        int size = size(input);
        if (size == 1) return input;
        ListNode reversedInput = reverse(copy(input));
        int index = 0;
        ListNode head = new ListNode(0);
        head.next = input;

        ListNode currentA = input;
        ListNode nextA = input.next;
        ListNode currentB = reversedInput;
        ListNode nextB = reversedInput.next;
        ListNode previousB = null;
        while (index < size / 2) {
            currentA.next = currentB;
            currentB.next = nextA;
            currentA = nextA;
            nextA = nextA.next;
            previousB = currentB;
            currentB = nextB;
            nextB = nextB.next;
            index++;
        }
        if (size % 2 == 0) {
            previousB.next = null;
        } else {
            previousB.next = currentB;
            currentB.next = null;
        }
        return head.next;
    }

    private ListNode copy(ListNode input) {
        ListNode head = new ListNode(0);
        ListNode currentCopy = new ListNode(input.val);
        head.next = currentCopy;
        ListNode currentNode = input.next;
        while (currentNode != null) {
            currentCopy.next = new ListNode(currentNode.val);
            currentNode = currentNode.next;
            currentCopy = currentCopy.next;
        }
        return head.next;
    }

    private int size(ListNode listNode) {
        int count = 1;
        ListNode nextNode = listNode.next;
        while (nextNode != null) {
            nextNode = nextNode.next;
            count++;
        }
        return count;
    }

    private ListNode reverse(ListNode node) {
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
