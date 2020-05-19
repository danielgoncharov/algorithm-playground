package com.daniel.goncharov.algorithm.playground.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeastCommonAncestor {

    public int lca(TreeNode root, int firstValue, int secondValue) {
        Map<Integer, ArrayList<Integer>> currentPaths = new HashMap<>();
        currentPaths.put(firstValue, new ArrayList<>());
        currentPaths.put(secondValue, new ArrayList<>());
        findPath(root, new ArrayList<>(), currentPaths);
        ArrayList<Integer> firstPath = currentPaths.get(firstValue);
        ArrayList<Integer> secondPath = currentPaths.get(secondValue);
        int minSize = Math.min(firstPath.size(), secondPath.size());
        if (minSize == 0) return -1;
        for (int index = 0; index < minSize; index++) {
            if (firstPath.get(index) != secondPath.get(index)) {
                return firstPath.get(index - 1);
            }
        }
        if (firstPath.size() > secondPath.size()) {
            return secondPath.get(minSize - 1);
        } else {
            return firstPath.get(minSize - 1);
        }
    }

    private void findPath(
            TreeNode root,
            ArrayList<Integer> currentPath,
            Map<Integer, ArrayList<Integer>> currentPaths) {
        if (root == null) return;
        if (bothPathFound(currentPaths)) return;
        currentPath.add(root.val);
        if (currentPaths.containsKey(root.val)) {
            currentPaths.put(root.val, new ArrayList(currentPath));
        }
        findPath(root.left, currentPath, currentPaths);
        findPath(root.right, currentPath, currentPaths);
        currentPath.remove(currentPath.size() - 1);
    }

    private boolean bothPathFound(Map<Integer, ArrayList<Integer>> currentPaths) {
        for (ArrayList<Integer> arrayList : currentPaths.values()) {
            if (arrayList.isEmpty()) return false;
        }
        return true;
    }
}
