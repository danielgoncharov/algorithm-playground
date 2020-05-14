package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;

public class MinDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        result.add(Integer.MAX_VALUE);
        calculateMaxRoute(result, 0, root);
        return result.get(0);
    }

    private void calculateMaxRoute(ArrayList<Integer> result,
                                   int currentLevel,
                                   TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            int value = Math.min(result.get(0), currentLevel + 1);
            result.set(0, value);
        } else {
            calculateMaxRoute(result, currentLevel + 1, node.left);
            calculateMaxRoute(result, currentLevel + 1, node.right);
        }
    }

}
