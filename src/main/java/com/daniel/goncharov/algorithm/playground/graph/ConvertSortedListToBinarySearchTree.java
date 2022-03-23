package com.daniel.goncharov.algorithm.playground.graph;

import com.daniel.goncharov.algorithm.playground.linkedlist.ListNode;
import com.daniel.goncharov.algorithm.playground.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode linkedList) {
        List<Integer> list = getItems(linkedList);
        return constructTree(0, list.size() - 1, list);
    }

    private TreeNode constructTree(
            int start,
            int end,
            List<Integer> items) {
        if (start > end) return null;
        int middleIndex = (end - start) / 2 + start;
        int middleElement = items.get(middleIndex);
        TreeNode treeNode = new TreeNode(middleElement);
        treeNode.left = constructTree(start, middleIndex - 1, items);
        treeNode.right = constructTree(middleIndex + 1, end, items);
        return treeNode;
    }

    private List<Integer> getItems(ListNode currentNode) {
        List<Integer> items = new ArrayList<>();

        while (currentNode != null) {
            items.add(currentNode.val);
            currentNode = currentNode.next;
        }
        return items;
    }

}
