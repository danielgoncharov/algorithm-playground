package com.daniel.goncharov.algorithm.playground.tree;

import java.util.Deque;
import java.util.LinkedList;

public class NextPointerBinaryTree {

    public void connect(TreeLinkNode root) {
        Deque<Pair> deque = new LinkedList();
        int level = 0;
        TreeLinkNode currentNode = root;
        if (currentNode.left != null) {// is last level
            deque.add(new Pair(currentNode.left, level + 1));
            deque.add(new Pair(currentNode.right, level + 1));
        }
        while (!deque.isEmpty()) {
            Pair topOfDeque = deque.poll();
            if (topOfDeque.node.left != null) {// is last level
                deque.add(new Pair(topOfDeque.node.left, topOfDeque.level + 1));
                deque.add(new Pair(topOfDeque.node.right, topOfDeque.level + 1));
            }
            if (topOfDeque.level != level) {
                currentNode = topOfDeque.node;
                level = topOfDeque.level;
                continue;
            }
            //same level
            currentNode.next = topOfDeque.node;
            currentNode = topOfDeque.node;
        }
    }

    static class Pair {
        final TreeLinkNode node;
        final int level;

        public Pair(TreeLinkNode treeLinkNode, int level) {

            this.node = treeLinkNode;
            this.level = level;
        }
    }
}
