package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;

public class ConstructBinaryTreeFromInorderAndPreorder {

    public TreeNode buildTree(ArrayList<Integer> preOrdre, ArrayList<Integer> inorder) {
        TreeNode root = buildTree(
                inorder,
                0,
                inorder.size() - 1,
                preOrdre,
                0,
                preOrdre.size() - 1
        );
        return root;
    }

    private TreeNode buildTree(
            ArrayList<Integer> inOrder,
            int leftInOrder,
            int rightInOrder,
            ArrayList<Integer> preOrder,
            int leftPreOrder,
            int rightPreOrder) {
        if (leftInOrder > rightInOrder || leftPreOrder > rightPreOrder) return null;

        Integer rootVal = preOrder.get(leftPreOrder);
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = findIndex(inOrder, rootVal, leftInOrder, rightInOrder);

        int itemsToLeftInOrder = rootIndexInOrder - 1 - leftInOrder;
        root.left = buildTree(
                inOrder,
                leftInOrder,
                rootIndexInOrder - 1,

                preOrder,
                leftPreOrder + 1,
                leftPreOrder + 1 + itemsToLeftInOrder
        );

        int itemsToRightInOrder = rightInOrder - (rootIndexInOrder + 1);
        root.right = buildTree(
                inOrder,
                rootIndexInOrder + 1,
                rightInOrder,

                preOrder,
                rightPreOrder - itemsToRightInOrder
                ,
                rightPreOrder
        );

        return root;

    }

    private int findIndex(
            ArrayList<Integer> inOrder,
            Integer rootVal,
            int leftInOrder,
            int rightInOrder) {
        for (int index = leftInOrder; index <= rightInOrder; index++) {
            Integer current = inOrder.get(index);
            if (current.equals(rootVal)) return index;
        }
        throw new IndexOutOfBoundsException("Failed to find value " + rootVal + "in range " + leftInOrder + " - " + rightInOrder);
    }
}
