package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.*;
import java.util.stream.Collectors;


public class CycleUndirectedGraph {

    public int solve(int nodes, ArrayList<ArrayList<Integer>> connections) {
        Map<Integer, List<Integer>> adjacencyList = createAdjacencyList(connections);
        while (!adjacencyList.isEmpty()) {
            Queue<Node> deque = new LinkedList<>();
            int startingNode = (int) adjacencyList.keySet().toArray()[0];
            deque.add(new Node(startingNode, Node.NO_PARENT));
            Set<Integer> visitedNodes = new HashSet<>();
            while (!deque.isEmpty()) {
                Node node = deque.poll();
                if (visitedNodes.contains(node.id)) {
                    return 1;
                }
                visitedNodes.add(node.id);
                List<Node> neighbours = adjacencyList.get(node.id)
                        .stream()
                        .filter(item -> item != node.parentId)
                        .map(item -> new Node(item, node.id))
                        .collect(Collectors.toList());
                deque.addAll(neighbours);
            }
            visitedNodes
                    .stream()
                    .forEach(adjacencyList::remove);
            visitedNodes.clear();

        }
        return 0;
    }

    private Map<Integer, List<Integer>> createAdjacencyList(ArrayList<ArrayList<Integer>> connections) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        connections.stream()
                .forEach(item -> {
                    int from = item.get(0);
                    int to = item.get(1);
                    addToMap(from, to, adjacency);
                    addToMap(to, from, adjacency);
                });
        return adjacency;
    }

    private void addToMap(
            int from,
            int to,
            Map<Integer, List<Integer>> adjacency
    ) {
        List<Integer> neighbours = adjacency.getOrDefault(from, new ArrayList<>());
        neighbours.add(to);
        adjacency.put(from, neighbours);
    }

    static class Node {
        static final int NO_PARENT = -1;
        final int id;
        final int parentId;

        public Node(int node, int parent) {
            this.id = node;
            this.parentId = parent;
        }
    }
}
