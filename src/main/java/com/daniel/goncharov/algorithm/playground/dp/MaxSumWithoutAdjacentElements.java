package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxSumWithoutAdjacentElements {

    public int adjacent(ArrayList<ArrayList<Integer>> numbers) {
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Point> lastFourMax = new ArrayList<>();
        for (int j = 0; j < numbers.get(0).size(); j++) {
            for (int i = 0; i < numbers.size(); i++) {
                int currentElement = numbers.get(i).get(j);
                int newValue = currentElement + maxNotAdjusent(i, j, lastFourMax);
                maxSum = Math.max(maxSum, newValue);
                numbers.get(i).set(j, newValue);
                addLast(i, j, newValue, lastFourMax);
            }
        }
        return maxSum;

    }

    private void addLast(int i, int j, int newValue, ArrayList<Point> lastFourMax) {
        if (lastFourMax.size() == 4) {
            lastFourMax.remove(lastFourMax.size() - 1);
        }
        lastFourMax.add(new Point(i, j, newValue));
        Collections.sort(lastFourMax, Collections.reverseOrder(Comparator.comparing(o -> o.value)));
    }

    private int maxNotAdjusent(int currentI, int currentJ, ArrayList<Point> lastFourMax) {
        for (int i = 0; i < lastFourMax.size(); i++) {
            Point point = lastFourMax.get(i);
            if (
                // bottom
                    (currentI - 1 == point.x && currentJ == point.y) || //top adjustesent
                            (currentI == point.x && currentJ - 1 == point.y) || //left adjustesent
                            (currentI - 1 == point.x && currentJ - 1 == point.y) ||   //diagonal adjustesent
                            //top
                            (currentI + 1 == point.x && currentJ == point.y) ||
                            (currentI + 1 == point.x && currentJ - 1 == point.y)
            ) continue;
            return point.value;
        }
        return 0;
    }

    public static class Point {

        final int x;
        final int y;
        final Integer value;

        public Point(int i, int j, int newValue) {
            this.x = i;
            this.y = j;
            value = newValue;
        }
    }
}
