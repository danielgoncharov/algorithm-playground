package com.daniel.goncharov.algorithm.playground.linkedlist;

public class RotateList {

    public ListNode rotateRight(ListNode inputList, int inputRotateNmber) {
        int size = size(inputList);
        int rotateNumber = inputRotateNmber % size;
        if (rotateNumber == 0) return inputList;
        ListNode startOfMove = move(inputList, size - rotateNumber - 1);
        ListNode nodeToCopy = startOfMove.next;
        startOfMove.next = null;
        ListNode head = new ListNode(0);
        head.next = nodeToCopy;
        ListNode lastElement = move(nodeToCopy, rotateNumber - 1);
        lastElement.next = inputList;
        return head.next;
    }

    private ListNode move(ListNode listNode, int steps) {
        ListNode result = listNode;
        if (steps == 0) return result;
        while (steps != 0) {
            result = result.next;
            steps--;
        }
        return result;
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
}
