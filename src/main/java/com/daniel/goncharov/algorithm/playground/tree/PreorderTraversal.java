package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                if (currentNode.right != null) stack.push(currentNode.right);
                result.add(currentNode.val);
                currentNode = currentNode.left;
            }
            if (stack.isEmpty()) return result;
            currentNode = stack.pop();
        }
        return result;
    }
}