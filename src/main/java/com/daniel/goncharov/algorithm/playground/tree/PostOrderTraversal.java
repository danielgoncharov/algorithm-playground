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
                if (currentNode.right != null) stack.push(currentNode.right);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            if (!stack.isEmpty() && currentNode.right == stack.peek()) {
                TreeNode right = stack.pop();
                stack.push(currentNode);
                currentNode = right;
            } else {
                result.add(currentNode.val);
                currentNode = null;
            }
        }
        return result;
    }
}
