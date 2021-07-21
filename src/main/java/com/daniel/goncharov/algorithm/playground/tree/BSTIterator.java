package com.daniel.goncharov.algorithm.playground.tree;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode current;

    public BSTIterator(TreeNode root) {
        current=root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        TreeNode node = current;
        current = current.right;
        return node.val;
    }
}
