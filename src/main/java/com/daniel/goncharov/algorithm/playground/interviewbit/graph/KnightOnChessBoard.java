package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightOnChessBoard {

    public int knight(
            int width,
            int length,
            int knightX,
            int knightY,
            int destX,
            int destY
    ) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Point> deque = new LinkedList<>();
        deque.add(new Point(knightX, knightY));
        while (!deque.isEmpty()) {
            Point point = deque.poll();
            if (point.x == destX && point.y == destY) return point.layerIndex;

            addPoint(point.x - 1, point.y - 2, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x + 1, point.y - 2, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x + 2, point.y - 1, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x + 2, point.y + 1, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x + 1, point.y + 2, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x - 1, point.y + 2, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x - 2, point.y + 1, width, length, visitedNodes, deque, point.layerIndex);
            addPoint(point.x - 2, point.y - 1, width, length, visitedNodes, deque, point.layerIndex);
            visitedNodes.add(createLinear(point.x, point.y, width));

        }
        return -1;
    }

    private void addPoint(
            int i,
            int j,
            int width,
            int length,
            Set<Integer> visitedNodes,
            Queue<Point> deque,
            int layerIndex
    ) {
        if (i <= 0 || j <= 0 || i > width || j > length) return;
        int linearIndex = createLinear(i, j, width);
        if (visitedNodes.contains(linearIndex)) return;
        deque.add(new Point(i, j, layerIndex + 1));
    }

    private int createLinear(int i, int j, int width) {
        return (i - 1) * width + j;
    }


    static final class Point {

        final int x;
        final int y;
        final int layerIndex;

        public Point(int knightX, int knightY) {
            this.x = knightX;
            this.y = knightY;
            this.layerIndex = 0;
        }

        public Point(int knightX, int knightY, int layerIndex) {
            this.x = knightX;
            this.y = knightY;
            this.layerIndex = layerIndex;
        }
    }
}
