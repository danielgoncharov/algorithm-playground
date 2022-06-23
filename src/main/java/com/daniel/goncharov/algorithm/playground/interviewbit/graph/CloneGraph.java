package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.HashMap;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> labelsVisited = new HashMap<>();
        return cloneGraph(node, labelsVisited);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> labelsVisited) {
        if (labelsVisited.containsKey(node.label)) {
            return labelsVisited.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        labelsVisited.put(newNode.label, newNode);
        for (UndirectedGraphNode each : node.neighbors) {
            newNode.neighbors.add(cloneGraph(each, labelsVisited));
        }
        return newNode;
    }
}
