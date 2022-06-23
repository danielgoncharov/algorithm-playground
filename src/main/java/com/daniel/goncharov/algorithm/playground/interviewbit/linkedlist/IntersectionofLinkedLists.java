package com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist;

public class IntersectionofLinkedLists {

    public ListNode getIntersectionNode(ListNode left, ListNode right) {
        int leftSize = size(left);
        int rightSize = size(right);
        int skipCount = Math.abs(leftSize - rightSize);
        if (leftSize > rightSize) {
            left = move(left, skipCount);
        } else if (leftSize < rightSize) {
            right = move(right, skipCount);
        }
        while (left != null) {
            if (left.val == right.val) {
                return left;
            }
            left = left.next;
            right = right.next;
        }
        return null;
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

    private ListNode move(ListNode listNode, int steps) {
        ListNode result = listNode;
        if (steps == 0) return result;
        while (steps != 0) {
            result = result.next;
            steps--;
        }
        return result;
    }
}


