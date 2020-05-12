package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        findPath(root, 0, sum, arrayLists, new ArrayList<>());
        return arrayLists;
    }

    private void findPath(TreeNode node,
                          int currentSum,
                          int dedicatedSum,
                          ArrayList<ArrayList<Integer>> result,
                          ArrayList<Integer> currentArray) {
        if (node == null) return;
        int sumToCheck = node.val + currentSum;
        currentArray.add(node.val);
        if (node.left == null && node.right == null) {
            if (sumToCheck == dedicatedSum) {
                result.add(new ArrayList<>(currentArray));
            }
        } else {
            findPath(node.left, sumToCheck, dedicatedSum, result, currentArray);
            findPath(node.right, sumToCheck, dedicatedSum, result, currentArray);
        }
        currentArray.remove(currentArray.size() - 1);
    }
}
