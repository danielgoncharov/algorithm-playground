package com.daniel.goncharov.algorithm.playground.tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return mirror(root);
    }

    private TreeNode mirror(TreeNode node) {
        if (node == null) return null;
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        node.left = mirror(rightNode);
        node.right = mirror(leftNode);
        return node;
    }
}
