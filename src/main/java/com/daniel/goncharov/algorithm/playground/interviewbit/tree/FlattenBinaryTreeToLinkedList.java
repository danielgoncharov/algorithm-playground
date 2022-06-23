package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        postOrder(root, list);
        for (int index = 0; index < list.size(); index++) {
            TreeNode current = list.get(index);
            current.left = null;
            TreeNode next = null;
            int nextIndex = index + 1;
            if (nextIndex < list.size()) {
                next = list.get(nextIndex);
            }
            current.right = next;
        }
        return list.get(0);
    }

    private void postOrder(TreeNode node, ArrayList<TreeNode> nodes) {
        if (node == null) return;
        nodes.add(node);
        postOrder(node.left, nodes);
        postOrder(node.right, nodes);
    }
}
