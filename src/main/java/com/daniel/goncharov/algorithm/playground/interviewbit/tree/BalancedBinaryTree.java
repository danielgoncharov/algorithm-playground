package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

public class BalancedBinaryTree {

    public int isBalanced(TreeNode root) {
        return isBalancedTree(root) ? 1 : 0;
    }

    private boolean isBalancedTree(TreeNode root) {
        if (root == null) return true;
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        if (Math.abs(rightHeight - leftHeight) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right)) {
            return true;
        }
        return false;
    }

    private int calculateHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return Math.max(calculateHeight(treeNode.right), calculateHeight(treeNode.left)) + 1;
    }
}
