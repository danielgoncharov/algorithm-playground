package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

    int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
