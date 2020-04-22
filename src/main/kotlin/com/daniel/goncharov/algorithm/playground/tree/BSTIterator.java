package com.daniel.goncharov.algorithm.playground.tree;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    private HashSet<TreeNode> visitedTreeNode = new HashSet<>();

    public BSTIterator(TreeNode root) {
        stack.add(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return traverseToNext();
    }

    private int traverseToNext() {
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();

            if (treeNode.left == null && treeNode.right == null) {
                visitedTreeNode.add(treeNode);
                return stack.pop().val;
            }

            if (treeNode.left == null) {
                visitedTreeNode.add(treeNode);
                if (treeNode.right != null) stack.add(treeNode.right);
                return stack.pop().val;
            }

            //left is not null from here on
            if (!visitedTreeNode.contains(treeNode.left)) {
                stack.add(treeNode.left);
                continue;
            }

            visitedTreeNode.remove(treeNode.left);
            treeNode = stack.pop();
            if (treeNode.right != null) stack.add(treeNode.right);
            return treeNode.val;
        }
        throw new NoSuchElementException();
    }
}
