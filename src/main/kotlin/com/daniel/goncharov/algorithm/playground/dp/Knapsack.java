package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class Knapsack {

    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity) {
        return solveBottomUp(values, weights, capacity);
    }

    private int solveBottomUp(ArrayList<Integer> values,
                              ArrayList<Integer> weights,
                              int capacity) {
        int[][] cache = new int[weights.size() + 1][capacity + 1];
        int result = 0;
        for (int i = 0; i < cache.length; i++) {
            int[] row = cache[i];
            for (int weight = 0; weight < row.length; weight++) {
                if (i == 0 || weight == 0) {
                    row[weight] = 0;
                    continue;
                }
                int currentWeight = weights.get(i - 1);
                if (currentWeight > weight) {
                    row[weight] = cache[i - 1][weight];
                } else {
                    row[weight] = Math.max(
                            cache[i - 1][weight],
                            values.get(i - 1) + cache[i - 1][weight - currentWeight]
                    );
                }
                result = row[weight];
            }
        }
        return result;
    }

    private int solveRecursive(ArrayList<Integer> values,
                               ArrayList<Integer> weights,
                               int remainingSize,
                               int itemNumber) {
        if (remainingSize == 0 || itemNumber < 0) {
            return 0;
        }
        int currentWeight = weights.get(itemNumber);
        if (remainingSize - currentWeight < 0) {
            return solveRecursive(values, weights, remainingSize, itemNumber - 1);
        } else {
            return Math.max(
                    solveRecursive(values, weights, remainingSize, itemNumber - 1),
                    solveRecursive(values, weights, remainingSize - currentWeight, itemNumber - 1) + values.get(itemNumber)
            );
        }
    }
}
