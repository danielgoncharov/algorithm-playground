package com.daniel.goncharov.algorithm.playground.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return 1;
        if ((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null)) return 0;
        Deque<TreeNode> leftDeque = new LinkedList<>(Arrays.asList(leftTree));
        Deque<TreeNode> rightDeque = new LinkedList<>(Arrays.asList(rightTree));
        while (!leftDeque.isEmpty() && !rightDeque.isEmpty()) {
            TreeNode currentLeft = leftDeque.poll();
            TreeNode currentRight = rightDeque.poll();
            if (currentLeft.val != currentRight.val) return 0;
            if (currentLeft.left != null) leftDeque.add(currentLeft.left);
            if (currentLeft.right != null) leftDeque.add(currentLeft.right);
            if (currentRight.left != null) leftDeque.add(currentRight.left);
            if (currentRight.right != null) leftDeque.add(currentRight.right);
            if (leftDeque.size() != rightDeque.size()) return 0;
        }
        return 1;
    }
}
