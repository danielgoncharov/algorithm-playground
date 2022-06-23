package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.Deque;
import java.util.LinkedList;

public class NextPointerBinaryTree {

    public void connect(TreeLinkNode root) {
        int index = 1;
        int levelSeparator = 1;

        Deque<TreeLinkNode> deque = new LinkedList();
        deque.add(root);

        TreeLinkNode currentNode = null;
        while (!deque.isEmpty()) {
            TreeLinkNode topOfDeque = deque.poll();
            if (topOfDeque.left != null) {// is not last level
                deque.add(topOfDeque.left);
                deque.add(topOfDeque.right);
            }
            if (currentNode == null) {//root
                currentNode = topOfDeque;
            } else if (index / levelSeparator == 1) {//is on the same level
                currentNode.next = topOfDeque;
                currentNode = topOfDeque;
            } else {//different levels
                currentNode = topOfDeque;
                levelSeparator *= 2;
            }
            index++;
        }
    }
}
