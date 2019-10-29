package com.daniel.goncharov.algorithm.playground.linkedlist;

public class MergeTwoSortedList {
    ListNode result = null;
    ListNode currentNode = null;

    public ListNode mergeTwoLists(ListNode listA, ListNode listB) {

        while (listA != null || listB != null) {
            if (listA == null) {
                addToResult(listB.val);
                listB = listB.next;
                continue;
            }
            if (listB == null) {
                addToResult(listA.val);
                listA = listA.next;
                continue;
            }
            if (listA.val < listB.val) {
                addToResult(listA.val);
                listA = listA.next;
            } else {
                addToResult(listB.val);
                listB = listB.next;
            }
        }
        return result;
    }

    private void addToResult(int val) {
        if (result == null) {
            result = new ListNode(val);
            currentNode = result;
        } else {
            currentNode.next = new ListNode(val);
            currentNode = currentNode.next;
        }
    }
}
