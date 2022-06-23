package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInTree {

    public int kthsmallest(TreeNode root, int kSmallest) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list, kSmallest);
        return list.get(list.size() - 1);
    }

    private void inOrderTraversal(TreeNode current, List<Integer> elements, int kSmallest) {
        if (elements.size() == kSmallest) return;
        if (current == null) return;
        if (current.left == null && current.right == null) {
            elements.add(current.val);
            return;
        }
        inOrderTraversal(current.left, elements, kSmallest);
        if (elements.size() == kSmallest) return;
        elements.add(current.val);
        if (elements.size() == kSmallest) return;
        inOrderTraversal(current.right, elements, kSmallest);
    }
}
