package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
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
            if (stack.isEmpty() || stack.peek().right == null || stack.peek().right.val == currentNode.val) {
                currentNode = null;
            } else {
                currentNode = stack.peek().right;
            }
        }
        return result;
    }
}
