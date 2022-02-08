package com.daniel.goncharov.algorithm.playground.graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=4ZlRH0eK-qQ
// https://www.youtube.com/watch?v=wU6udHRIkcc
public class CommutableIslands {

    public int solve(
            int numberIslands,
            int[][] adjacency
    ) {
        return solveKruskal(numberIslands, adjacency);
    }


    private int solveKruskal(
            int numberIslands,
            int[][] adjacency
    ) {
        int[] disjointSet = IntStream.range(0, numberIslands)
                .map(ignored -> -1)
                .toArray();
        List<Node> nodes = createNodesList(adjacency);
        int sum = 0;
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.stream()
                    .min(Node::compareTo)
                    .get();
            if (unionFind(disjointSet, currentNode)) {
                sum += currentNode.weight;
            }
            nodes.remove(currentNode);
        }
        return sum;
    }

    private boolean unionFind(int[] disjointSet, Node currentNode) {
        int firstIndex = currentNode.firstIndex;
        int secondIndex = currentNode.secondIndex;

        int firstIndexParent = findParent(disjointSet, firstIndex - 1);
        int secondIndexParent = findParent(disjointSet, secondIndex - 1);

        if (firstIndexParent == secondIndexParent) {
            return false;
        }

        if (disjointSet[firstIndexParent] <= disjointSet[secondIndexParent]) {
            disjointSet[firstIndexParent] = disjointSet[firstIndexParent] + disjointSet[secondIndexParent];
            disjointSet[secondIndexParent] = firstIndexParent;
        } else {
            disjointSet[secondIndexParent] = disjointSet[firstIndexParent] + disjointSet[secondIndexParent];
            disjointSet[firstIndexParent] = secondIndexParent;
        }
        return true;
    }

    private int findParent(int[] disjointSet, int index) {
        if (disjointSet[index] > 0) {
            return findParent(disjointSet, disjointSet[index]);
        } else {
            return index;
        }
    }

    private int solvePrim(
            int numberIslands,
            int[][] adjacency
    ) {
        List<Node> nodes = createNodesList(adjacency);
        Node minEdge = Collections.min(nodes);
        nodes.remove(minEdge);
        int sum = 0;
        Set<Integer> visitedSet = new HashSet<>();
        while (visitedSet.size() == numberIslands) {
            Node currentNode = nodes.stream()
                    .filter(node -> visitedSet.contains(node.firstIndex) ^ visitedSet.contains(node.secondIndex))
                    .min(Node::compareTo)
                    .get();
            nodes.remove(currentNode);
            visitedSet.add(currentNode.firstIndex);
            visitedSet.add(currentNode.secondIndex);
            sum += currentNode.weight;
        }
        return sum;
    }

    private List<Node> createNodesList(
            int[][] adjacency
    ) {
        return IntStream.range(0, adjacency.length)
                .mapToObj(index -> new Node(index, adjacency[index][0], adjacency[index][1], adjacency[index][2]))
                .collect(Collectors.toList());
    }


    private static class Node implements Comparable<Node> {
        final int id;
        final int firstIndex;
        final int secondIndex;
        final Integer weight;

        public Node(int id, int firstIndex, int secondIndex, int weight) {
            this.id = id;
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public int compareTo(@NotNull Node object) {
            return weight.compareTo(object.weight);
        }
    }
}
