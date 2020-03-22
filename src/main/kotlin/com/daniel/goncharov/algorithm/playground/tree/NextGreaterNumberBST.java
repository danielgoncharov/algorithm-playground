package com.daniel.goncharov.algorithm.playground.tree;

import java.util.LinkedHashSet;
import java.util.Stack;

public class NextGreaterNumberBST {

    public TreeNode getSuccessor(TreeNode root, int anchor) {

        Stack<TreeNode> stack = new Stack<>();
        LinkedHashSet<TreeNode> visitedNodes = new LinkedHashSet<>();
        TreeNode inspectNode = root;
        while (inspectNode != null) {
            if (inspectNode.left == null && inspectNode.right == null) {
                visitedNodes.add(inspectNode);
                inspectNode = stack.isEmpty() ? null : stack.pop();
            } else if (inspectNode.left != null && !visitedNodes.contains(inspectNode.left)) {
                if (inspectNode.right != null) stack.add(inspectNode.right);
                stack.add(inspectNode);
                inspectNode = inspectNode.left;
            } else if (inspectNode.left != null && visitedNodes.contains(inspectNode.left)) {
                visitedNodes.add(inspectNode);
                inspectNode = stack.isEmpty() ? null : stack.pop();
            } else if (inspectNode.left == null && inspectNode.right != null) {
                visitedNodes.add(inspectNode);
                inspectNode = inspectNode.right;
            }
        }
        for (TreeNode treeNode : visitedNodes) if (treeNode.val > anchor) return treeNode;
        return null;
    }

}
