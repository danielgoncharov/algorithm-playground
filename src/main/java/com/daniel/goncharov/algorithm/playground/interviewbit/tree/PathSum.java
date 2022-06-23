package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;

public class PathSum {

    public int hasPathSum(TreeNode root, int sum) {
        ArrayList<Boolean> result = new ArrayList<>();
        result.add(false);
        findPath(root, 0, sum, result);
        return result.get(0) ? 1 : 0;
    }

    private void findPath(TreeNode node,
                          int currentSum,
                          int dedicatedSum,
                          ArrayList<Boolean> result) {
        if (result.get(0) || node == null) return;
        int sumToCheck = node.val + currentSum;
        if (sumToCheck == dedicatedSum && node.left == null && node.right == null) result.set(0, true);
        findPath(node.left, sumToCheck, dedicatedSum, result);
        findPath(node.right, sumToCheck, dedicatedSum, result);
    }
}
