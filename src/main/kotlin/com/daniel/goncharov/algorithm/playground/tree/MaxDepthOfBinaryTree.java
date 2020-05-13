package com.daniel.goncharov.algorithm.playground.tree;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = 1 + maxDepth(node.left);
        int right = 1 + maxDepth(node.right);
        return Math.max(left, right);
    }
}
