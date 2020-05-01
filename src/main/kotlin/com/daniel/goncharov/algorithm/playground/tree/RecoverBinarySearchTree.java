package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class RecoverBinarySearchTree {

    public ArrayList<Integer> recoverTree(TreeNode root) {
        TreeNode currentElement = root;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int previousValue = Integer.MIN_VALUE;
        TreeNode adjusent = null;
        while (!stack.isEmpty() || currentElement != null || result.size() == 2) {
            while (currentElement != null) {
                stack.add(currentElement);
                currentElement = currentElement.left;
            }
            if (stack.isEmpty()) break;
            currentElement = stack.pop();
            if (previousValue > currentElement.val) {
                result.add(previousValue);
                adjusent = currentElement;
            }
            previousValue = currentElement.val;
            currentElement = currentElement.right;
        }
        if (result.size() < 2 && adjusent != null) {
            result.add(adjusent.val);
        }
        Collections.sort(result);
        return result;
    }

}
