package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBinarySearchTree {

    public ArrayList<Integer> recoverTree(TreeNode root) {
        TreeNode currentElement = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        while (!stack.isEmpty() || currentElement != null) {
            while (currentElement != null) {
                stack.add(currentElement);
                currentElement = currentElement.left;
            }
            if (stack.isEmpty()) break;
            currentElement = stack.pop();
            if (previous != null && previous.val > currentElement.val) {
                left = Math.min(left, Math.min(currentElement.val, previous.val));
                right = Math.max(right, Math.max(currentElement.val, previous.val));
            }
            previous = currentElement;
            currentElement = currentElement.right;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(left);
        result.add(right);
        return result;
    }

}
