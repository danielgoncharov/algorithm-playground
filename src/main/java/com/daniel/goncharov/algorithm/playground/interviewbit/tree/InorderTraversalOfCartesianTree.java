package com.daniel.goncharov.algorithm.playground.interviewbit.tree;

import java.util.ArrayList;

public class InorderTraversalOfCartesianTree {

    public TreeNode buildTree(ArrayList<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        TreeNode root = new TreeNode(0);
        buildCartesianTree(root, list, start, end);
        return root;
    }

    private void buildCartesianTree(TreeNode node,
                                    ArrayList<Integer> list,
                                    int start,
                                    int end) {
        int index = getMaxIndex(list, start, end);
        node.val = list.get(index);
        if (index - 1 >= start) {
            TreeNode left = new TreeNode(0);
            node.left = left;
            buildCartesianTree(
                    left,
                    list,
                    start,
                    index - 1
            );
        }
        if (index + 1 <= end) {
            TreeNode right = new TreeNode(0);
            node.right = right;
            buildCartesianTree(
                    right,
                    list,
                    index + 1,
                    end
            );
        }
    }

    private int getMaxIndex(ArrayList<Integer> list, int start, int end) {
        int max = Integer.MIN_VALUE;
        int indexMax = start;
        for (int index = start; index <= end; index++) {
            int current = list.get(index);
            if (current > max) {
                max = current;
                indexMax = index;
            }
        }
        return indexMax;
    }
}
