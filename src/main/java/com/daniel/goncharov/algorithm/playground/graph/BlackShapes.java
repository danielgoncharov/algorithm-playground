package com.daniel.goncharov.algorithm.playground.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlackShapes {

    public int black(ArrayList<String> matrix) {
        List<List<Node>> nodeMatrix = createNodeList(matrix);
        int count = 0;
        for (List<Node> row : nodeMatrix) {
            for (Node currentNode : row) {
                count += processNode(currentNode, nodeMatrix);
            }
        }
        return count;
    }

    private int processNode(Node currentNode, List<List<Node>> nodeMatrix) {
        if (!currentNode.isBlack || currentNode.isVisited) return 0;
        Stack<Node> stack = new Stack<>();
        stack.add(currentNode);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.visited();

            int indexNodeToTop = node.i - 1;
            if (indexNodeToTop > 0) {
                Node nodeToTop = nodeMatrix.get(indexNodeToTop).get(node.j);
                addNodeToStack(nodeToTop, stack);
            }

            int indexNodeToBottom = node.i + 1;
            if (indexNodeToBottom < nodeMatrix.size()) {
                Node nodeToBottom = nodeMatrix.get(indexNodeToBottom).get(node.j);
                addNodeToStack(nodeToBottom, stack);
            }

            int indexNodeToRight = node.j + 1;
            if (indexNodeToRight < nodeMatrix.get(0).size()) {
                Node nodeToRight = nodeMatrix.get(node.i).get(indexNodeToRight);
                addNodeToStack(nodeToRight, stack);
            }

            int indexNodeToLeft = node.j - 1;
            if (indexNodeToLeft > 0) {
                Node nodeToLeft = nodeMatrix.get(node.i).get(indexNodeToLeft);
                addNodeToStack(nodeToLeft, stack);
            }
        }
        return 1;
    }

    private void addNodeToStack(
            Node nodeToBottom,
            Stack<Node> stack
    ) {
        if (nodeToBottom.isBlack && !nodeToBottom.isVisited) {
            stack.add(nodeToBottom);
        }
    }

    private List<List<Node>> createNodeList(ArrayList<String> matrix) {
        List<List<Node>> nodeMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            String string = matrix.get(i);
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < string.length(); j++) {
                char character = string.charAt(j);
                list.add(new Node(character == 'X', i, j));
            }
            nodeMatrix.add(list);
        }
        return nodeMatrix;
    }

    private static class Node {
        boolean isVisited = false;
        boolean isBlack;
        int i;
        int j;

        public Node(boolean isBlack, int i, int j) {
            this.isBlack = isBlack;
            this.i = i;
            this.j = j;
        }

        public void visited() {
            isVisited = true;
        }
    }
}
