package com.daniel.goncharov.algorithm.playground.heap;

import com.daniel.goncharov.algorithm.playground.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> {
            int x = o1.val;
            int y = o2.val;
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        });
        for (ListNode listNode : lists) {
            addToHeap(listNode, heap);
        }

        ListNode top = new ListNode(0);
        ListNode current = top;
        while (!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
        }
        return top.next;
    }

    private void addToHeap(ListNode listNode, PriorityQueue<ListNode> heap) {
        while (listNode != null) {
            heap.add(listNode);
            listNode = listNode.next;
        }
    }

}
