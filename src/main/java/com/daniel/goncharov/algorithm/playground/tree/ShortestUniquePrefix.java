package com.daniel.goncharov.algorithm.playground.tree;

import java.util.*;

public class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> items) {
        TreeNode root = new TreeNode(' ', 0);
        for (int index = 0; index < items.size(); index++) {
            addItemToRoot(items.get(index), root, index);
        }
        ArrayList<Result> result = new ArrayList<>();
        for (Map.Entry<Character, TreeNode> entry : root.children.entrySet()) {
            collectResult(entry.getValue(), new StringBuilder(), result);
        }
        Collections.sort(result, Comparator.comparing(item -> item.index));
        ArrayList<String> resultString = new ArrayList<>();
        for (int index = 0; index < result.size(); index++) {
            resultString.add(result.get(index).string);
        }
        return resultString;
    }

    private void collectResult(TreeNode node, StringBuilder tempResult, ArrayList<Result> result) {
        if (node == null) return;
        tempResult.append(node.val);
        if (node.isUniquePrefix()) {
            result.add(new Result(tempResult.toString(), node.index));
        } else {
            for (Map.Entry<Character, TreeNode> entry : node.children.entrySet()) {
                collectResult(entry.getValue(), tempResult, result);
            }
        }
        tempResult.deleteCharAt(tempResult.length() - 1);
    }

    private void addItemToRoot(String item, TreeNode root, int index) {
        TreeNode currentTreeNode = root;
        for (Character character : item.toCharArray()) {
            if (currentTreeNode.children.containsKey(character)) {
                currentTreeNode = currentTreeNode.children.get(character);
                currentTreeNode.addVisits();
            } else {
                TreeNode missingNode = new TreeNode(character, index);
                currentTreeNode.children.put(character, missingNode);
                currentTreeNode = missingNode;
            }
        }
    }

    private static final class Result {
        Integer index;
        String string;

        public Result(String string, int index) {
            this.string = string;
            this.index = index;
        }
    }

    private static final class TreeNode {
        Character val;
        private int visitsCount = 0;
        int index = 0;
        Map<Character, TreeNode> children = new HashMap<>();

        public TreeNode(Character val, int index) {
            this.val = val;
            this.index = index;
        }

        public void addVisits() {
            visitsCount++;
        }

        public boolean isUniquePrefix() {
            return visitsCount == 0;
        }
    }

}


