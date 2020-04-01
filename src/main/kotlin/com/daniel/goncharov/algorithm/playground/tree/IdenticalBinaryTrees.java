package com.daniel.goncharov.algorithm.playground.tree;

public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode leftTree, TreeNode rightTree) {
        return areSameTrees(leftTree, rightTree) ? 1 : 0;
    }

    private boolean areSameTrees(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        return leftTree.val == rightTree.val
                && areSameTrees(leftTree.left, rightTree.left)
                && areSameTrees(leftTree.right, rightTree.right);
    }
}
