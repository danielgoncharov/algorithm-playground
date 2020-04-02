package com.daniel.goncharov.algorithm.playground.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode root) {
        Deque<TreeNode> symmetricCheckNodeDeque = new LinkedList<>();
        Deque<TreeNode> layerDeque = new LinkedList<>(Arrays.asList(root));
        int nextSize = 2;
        while (layerDeque.isEmpty()) {
            if (layerDeque.size() == nextSize) {
                while (!symmetricCheckNodeDeque.isEmpty()) {
                    TreeNode leftCorner = symmetricCheckNodeDeque.removeFirst();
                    TreeNode rightCorner = symmetricCheckNodeDeque.removeLast();
                    if (leftCorner == null && rightCorner == null) continue;
                    if (leftCorner == null || rightCorner == null) return 0;
                    if (leftCorner.val != rightCorner.val) return 0;
                }
                nextSize *= 2;
            }
            TreeNode currentTreeNode = layerDeque.poll();
            layerDeque.add(currentTreeNode.left);
            layerDeque.add(currentTreeNode.right);
            symmetricCheckNodeDeque.push(currentTreeNode.left);
            symmetricCheckNodeDeque.add(currentTreeNode.right);
        }
        return 1;
    }
}
