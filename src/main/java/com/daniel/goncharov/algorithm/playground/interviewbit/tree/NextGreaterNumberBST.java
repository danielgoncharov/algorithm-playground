package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.Stack;

public class NextGreaterNumberBST {

    public TreeNode getSuccessor(TreeNode root, int anchor) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode inspectNode = root;
        while (!stack.isEmpty() || inspectNode != null) {
            TreeNode topOfTheStack = inspectNode;
            while (topOfTheStack != null) {
                stack.add(topOfTheStack);
                topOfTheStack = topOfTheStack.left;
            }
            topOfTheStack = stack.pop();
            if (topOfTheStack.val > anchor) return topOfTheStack;
            inspectNode = topOfTheStack.right;
        }
        return null;
    }

}
