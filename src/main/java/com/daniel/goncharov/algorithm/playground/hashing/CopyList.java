package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode deepCopyPointer = new RandomListNode(0);
        RandomListNode copyNode = deepCopyPointer;
        RandomListNode current = head;
        while (current != null) {
            if (map.containsKey(current)) {
                copyNode.next = map.get(current);
            } else {
                copyNode.next = new RandomListNode(current.label);
                map.put(current, copyNode.next);
            }
            copyNode = copyNode.next;
            if (map.containsKey(current.random)) {
                copyNode.random = map.get(current.random);
            } else if (current.random != null) {
                copyNode.random = new RandomListNode(current.random.label);
                map.put(current.random, copyNode.random);
            }
            current = current.next;
        }
        return deepCopyPointer.next;
    }
}