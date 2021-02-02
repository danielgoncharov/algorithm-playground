package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class Knapsack {

    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity) {
        return solveRecursive(values, weights, capacity, values.size() - 1);
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
