package com.daniel.goncharov.algorithm.playground.graph;

import java.util.*;

public class WordLadder1 {

    public int solve(String startWord, String targetWord, ArrayList<String> dict) {
        Map<String, List<String>> adjacencyMatrix = buildMatrix(startWord, targetWord, dict);
        Set<String> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startWord, 0));
        visited.add(startWord);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            List<String> adjacentWords = adjacencyMatrix.get(point.text);
            if (adjacentWords.contains(targetWord)) {
                return point.step + 1;
            } else {
                addToQueue(adjacentWords, visited, point.step, queue);
            }
        }
        return 0;
    }

    private Map<String, List<String>> buildMatrix(String startWord, String targetWord, ArrayList<String> dict) {
        return null;
    }

    private void addToQueue(List<String> adjacentWords, Set<String> visited, int step, Queue<Point> queue) {
        for (String word : adjacentWords) {
            if (!visited.contains(word)) {
                queue.add(new Point(word, step + 1));
            }
        }
    }

    private static class Point {
        final String text;
        final int step;

        public Point(String text, int step) {
            this.text = text;
            this.step = step;
        }
    }
}
