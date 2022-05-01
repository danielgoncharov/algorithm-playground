package com.daniel.goncharov.algorithm.playground.graph;

import java.util.*;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Set<UndirectedGraphNode>> newConnectionsMap = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.add(node);
        UndirectedGraphNode cloneRoot = null;
        while (!queue.isEmpty()) {
            UndirectedGraphNode parent = queue.poll();
            if (visited.contains(parent)) continue;
            UndirectedGraphNode clone = new UndirectedGraphNode(parent.label);
            newConnectionsMap.getOrDefault(parent, Collections.emptySet())
                    .stream()
                    .forEach(undirectedGraphNode -> {
                        clone.neighbors.add(undirectedGraphNode);
                        undirectedGraphNode.neighbors.add(clone);
                    });
            for (UndirectedGraphNode child : parent.neighbors) {
                if (visited.contains(child)) continue;
                queue.add(child);
                Set<UndirectedGraphNode> set = newConnectionsMap.getOrDefault(child, new HashSet<>());
                if (cloneRoot == null) {
                    cloneRoot = clone;
                }
                set.add(clone);
                newConnectionsMap.put(child, set);
            }
            visited.add(parent);
        }
        return cloneRoot;
    }
}
