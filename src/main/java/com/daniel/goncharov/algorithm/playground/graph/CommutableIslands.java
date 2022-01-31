package com.daniel.goncharov.algorithm.playground.graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

// https://www.youtube.com/watch?v=4ZlRH0eK-qQ
// https://www.youtube.com/watch?v=wU6udHRIkcc
public class CommutableIslands {

    public int solve(
            int numberIslands,
            int[][] adjacency
    ) {

    }


    private int solveKruskal() {
        return 0;
    }

    private int solvePrim(
            int numberIslands,
            int[][] adjacency
    ) {
        List<Node> nodes =
                Arrays.stream(adjacency)
                        .map(array -> new Node(array[0], array[1], array[2]))
                        .collect(Collectors.toList());
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


    private static class Node implements Comparable<Node> {
        final int firstIndex;
        final int secondIndex;
        final Integer weight;

        public Node(int firstIndex, int secondIndex, int weight) {

            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return firstIndex == node.firstIndex && secondIndex == node.secondIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstIndex, secondIndex);
        }

        @Override
        public int compareTo(@NotNull Node object) {
            return weight.compareTo(object.weight);
        }
    }
}
