package com.daniel.goncharov.algorithm.playground.dp;

import com.daniel.goncharov.algorithm.playground.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxSumPathInBinaryTree {

    public int maxPathSum(TreeNode root) {
        return maxPathSumRec(root, new HashMap<>());
    }

    private int maxPathSumRec(
            TreeNode root,
            Map<TreeNode, Integer> cache
    ) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (cache.containsKey(root)) return cache.get(root);

        return max(
                maxPathSumRec(root.left, cache),
                maxPathSumRec(root.right, cache),
                root.val + maxPathSumRec(root.left, cache) + maxPathSumRec(root.right, cache),
                root.val + maxPathSumRec(root.left, cache),
                root.val + maxPathSumRec(root.right, cache)
        );
    }

    private int max(int a, int b, int c, int d, int e) {
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
    }
}
