package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;

public class ZigZagLevelOrderTraversalBT {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        addZigZag(0, true, result, root);
        return result;
    }

    private void addZigZag(
            int levelIndex,
            boolean leftToRight,
            ArrayList<ArrayList<Integer>> layers,
            TreeNode node
    ) {
        if (node == null) return;
        ArrayList<Integer> layer;
        if (levelIndex >= layers.size()) {
            layer = new ArrayList<>();
            layers.add(layer);
        } else {
            layer = layers.get(levelIndex);
        }
        if (leftToRight) {
            layer.add(node.val);
        } else {
            layer.add(0, node.val);
        }
        addZigZag(levelIndex + 1, !leftToRight, layers, node.left);
        addZigZag(levelIndex + 1, !leftToRight, layers, node.right);
    }
}
