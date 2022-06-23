package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

public class ValidBinarySearchTree {

    public int isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBST(TreeNode node, int leftBorder, int rightBorder) {
        if (node == null) {
            return true;
        }
        if (
                leftBorder < node.val && node.val < rightBorder
                        && isValidBST(node.left, leftBorder, node.val)
                        && isValidBST(node.right, node.val, rightBorder)

        ) {
            return true;
        } else {
            return false;
        }
    }
}
