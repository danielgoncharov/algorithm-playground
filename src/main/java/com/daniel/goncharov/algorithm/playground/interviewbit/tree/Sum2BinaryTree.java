package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;
import java.util.List;

public class Sum2BinaryTree {

    public int t2Sum(TreeNode root, int sumOfTwo) {
        List<Integer> list = new ArrayList<>();
        traverseInOrder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            Integer leftValue = list.get(left);
            Integer rightValue = list.get(right);
            int sumToCheck = leftValue + rightValue;
            if (sumToCheck > sumOfTwo) {
                right--;
            } else if (sumToCheck < sumOfTwo) {
                left++;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private void traverseInOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        if (treeNode.left == null && treeNode.right == null) {
            list.add(treeNode.val);
            return;
        }
        traverseInOrder(treeNode.left, list);
        list.add(treeNode.val);
        traverseInOrder(treeNode.right, list);
    }
}
