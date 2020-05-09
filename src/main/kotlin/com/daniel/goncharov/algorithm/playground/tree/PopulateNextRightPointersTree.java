package com.daniel.goncharov.algorithm.playground.tree;

import java.util.Deque;
import java.util.LinkedList;

public class PopulateNextRightPointersTree {

    public void connect(TreeLinkNode root) {

        Deque<TreeLinkNode> deque = new LinkedList();
        deque.add(root);
        int currentLevelCount = deque.size();

        TreeLinkNode previousNode = null;
        while (!deque.isEmpty()) {
            TreeLinkNode topOfDeque = deque.poll();
            currentLevelCount--;
            if (topOfDeque.left != null) deque.add(topOfDeque.left);

            if (topOfDeque.right != null) deque.add(topOfDeque.right);

            if (currentLevelCount == 0) {
                currentLevelCount = deque.size();
                if (previousNode != null) previousNode.next = topOfDeque;
                previousNode = null;
            } else if (previousNode == null) {
                previousNode = topOfDeque;
            } else {
                previousNode.next = topOfDeque;
                previousNode = topOfDeque;
            }
        }
    }
}
