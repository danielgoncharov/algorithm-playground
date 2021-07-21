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
        if (root == null) return -2000;
        if (root.left == null && root.right == null) return root.val;
        if (cache.containsKey(root)) return cache.get(root);

        int maxForRoot = max(
                maxPathSumRec(root.left, cache),
                maxPathSumRec(root.right, cache),
                root.val + maxPathSumRec(root.left, cache) + maxPathSumRec(root.right, cache),
                root.val + maxPathSumRec(root.left, cache),
                root.val + maxPathSumRec(root.right, cache),
                root.val
        );
        cache.put(root, maxForRoot);
        return maxForRoot;
    }

    private int max(int a, int b, int c, int d, int e, int f) {
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, Math.max(e, f)))));
    }
}
