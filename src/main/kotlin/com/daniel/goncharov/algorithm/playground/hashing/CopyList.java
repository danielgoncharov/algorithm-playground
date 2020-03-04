package com.daniel.goncharov.algorithm.playground.hashing;

public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode deepCopyPointer = new RandomListNode(0);
        RandomListNode copyNode = new RandomListNode(head.label);
        deepCopyPointer.next = copyNode;
        RandomListNode current = head.next;
        while (current != null) {
            copyNode.next = new RandomListNode(current.label);
            copyNode = copyNode.next;
            current = current.next;
        }
        return deepCopyPointer.next;
    }
}