package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }
}
