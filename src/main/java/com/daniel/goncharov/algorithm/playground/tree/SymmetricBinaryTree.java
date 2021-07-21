package com.daniel.goncharov.algorithm.playground.tree;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode root) {
        return isSymmetricNodes(root.left, root.right) ? 1 : 0;
    }

    private boolean isSymmetricNodes(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricNodes(left.right, right.left) && isSymmetricNodes(left.left, right.right);
    }
}
