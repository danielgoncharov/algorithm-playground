package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class MaximumSizeSquareSubMatrix {

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int max = 0;
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                int currentItem = row.get(j);
                if (currentItem == 1) {
                    int newItem = min(matrix, i, j);
                    max = Math.max(max, newItem);
                    row.set(j, newItem);
                }
            }
        }
        return max*max;
    }

    private int min(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        int fromLeft = 0;
        if (j - 1 >= 0) {
            fromLeft = matrix.get(i).get(j - 1);
        }
        int fromTop = 0;
        if (i - 1 >= 0) {
            fromTop = matrix.get(i - 1).get(j);
        }
        int diagonal = 0;
        if (j - 1 >= 0 && i - 1 >= 0) {
            diagonal = matrix.get(i - 1).get(j - 1);
        }
        return Math.min(Math.min(diagonal, fromLeft), fromTop) + 1;
    }
}
