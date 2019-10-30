package com.daniel.goncharov.algorithm.playground.linkedlist;

public class RemoveNNodeFromList {

    public ListNode removeNthFromEnd(ListNode list, int position) {
        ListNode head = new ListNode(0);
        head.next = list;
        int size = size(list);
        if (size < position || size - position == 0) {
            return list.next;
        }
        int index = 1;
        ListNode listNode = list;
        while (index != size - position) {
            listNode = listNode.next;
            index++;
        }
        listNode.next = listNode.next.next;
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
}
