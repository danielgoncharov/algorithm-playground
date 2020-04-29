package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBinarySearchTree {

    public ArrayList<Integer> recoverTree(TreeNode root) {
        TreeNode currentElement = root;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        Integer previousValue = null;
        while (!stack.isEmpty() || currentElement != null || result.size() == 2) {
            while (currentElement != null) {
                stack.add(currentElement);
                currentElement = currentElement.left;
            }
            currentElement = stack.pop();
            if (previousValue != null && previousValue.compareTo(currentElement.val) == 1) {
                result.add(previousValue);
            }
            previousValue = currentElement.val;
            currentElement = currentElement.right;
        }
        return result;
    }

}
