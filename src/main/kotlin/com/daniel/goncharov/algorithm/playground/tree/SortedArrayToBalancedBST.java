package com.daniel.goncharov.algorithm.playground.tree;

import java.util.List;

public class SortedArrayToBalancedBST {

    public TreeNode sortedArrayToBST(List<Integer> array) {
        TreeNode treeNode = new TreeNode(0);
        createBST(treeNode, 0, array.size() - 1, array);
        return treeNode;
    }

    private void createBST(
            TreeNode treeNode,
            int start,
            int end,
            List<Integer> array
    ) {
        int middle = (end + start) / 2;
        treeNode.val = array.get(middle);
        if (middle - 1 >= start) {
            TreeNode left = new TreeNode(0);
            treeNode.left = left;
            createBST(treeNode, start, middle - 1, array);
        }
        if (middle + 1 <= end) {
            TreeNode right = new TreeNode(0);
            treeNode.right = right;
            createBST(treeNode, middle + 1, end, array);
        }
    }


}
