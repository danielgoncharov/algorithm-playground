package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        return buildTree(

                inOrder,
                0,
                inOrder.size() - 1,
                postOrder,
                0,
                postOrder.size() - 1
        );
    }

    private TreeNode buildTree(
            ArrayList<Integer> inOrder,
            int leftInOrder,
            int rightInOrder,
            ArrayList<Integer> postOrder,
            int leftPostOrder,
            int rightPostOrder) {
        if (leftInOrder > rightInOrder || leftPostOrder > rightPostOrder) return null;

        Integer rootVal = postOrder.get(rightPostOrder);
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = inOrder.indexOf(rootVal);

        int itemsToLeftInOrder = rootIndexInOrder - 1 - leftInOrder;
        root.left = buildTree(
                inOrder,
                leftInOrder,
                rootIndexInOrder - 1,

                postOrder,
                leftPostOrder,
                leftPostOrder + itemsToLeftInOrder
        );

        int itemsToRightInOrder = rightInOrder - (rootIndexInOrder + 1);
        root.right = buildTree(
                inOrder,
                rootIndexInOrder + 1,
                rightInOrder,

                postOrder,
                rightPostOrder - 1 - itemsToRightInOrder
                ,
                rightPostOrder - 1
        );

        return root;

    }
}
