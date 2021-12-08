package com.daniel.goncharov.algorithm.playground.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        int currentLevel = 1;
        int nextLevel = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            currentList.add(node.val);
            currentLevel--;
            if (node.left != null) {
                nextLevel++;
                deque.add(node.left);
            }
            if (node.right != null) {
                nextLevel++;
                deque.add(node.right);
            }
            if (currentLevel == 0) {
                result.add(currentList);
                currentList = new ArrayList();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

}
