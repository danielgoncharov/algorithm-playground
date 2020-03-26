package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BalancedBinaryTree {

    public int isBalanced(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int stackHeight = 1;
        TreeNode currentNode = root;
        do {
            if (currentNode.left == null && currentNode.right == null) {
                currentNode = stack.pop();
            } else if (currentNode.left == null && currentNode.right != null) {
                min = Math.min(min, stackHeight);
                max = Math.max(max, stackHeight);
                stack.add(currentNode.right);
            } else if (currentNode.left != null && currentNode.right == null) {
                min = Math.min(min, stackHeight);
                max = Math.max(max, stackHeight);
                stack.add(currentNode.left);
            } else {
                stack.add(currentNode.left);
                stack.add(currentNode.right);
            }
        } while (currentNode != null && !stack.isEmpty());
        return Math.abs(max - min) > 1 ? 0 : 1;
    }

    private void fun(ArrayList<Integer> minMax, HashSet<TreeNode> visited, TreeNode treeNode) {

    }
}
