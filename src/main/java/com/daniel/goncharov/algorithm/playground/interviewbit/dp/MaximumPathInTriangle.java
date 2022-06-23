package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;

public class MaximumPathInTriangle {
    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < i + 1; j++) {
                int fromTop = getFromTop(i, j, matrix);
                int fromTopLeft = getFromTopLeft(i, j, matrix);
                int valueToSet = Math.max(fromTop, fromTopLeft)+ matrix.get(i).get(j);
                max = Math.max(max, valueToSet) ;
                row.set(j, valueToSet);
            }
        }
        return max;
    }

    private int getFromTop(int i, int j, ArrayList<ArrayList<Integer>> matrix) {
        if (i - 1 < 0) return 0;
        else return matrix.get(i - 1).get(j);
    }

    private int getFromTopLeft(int i, int j, ArrayList<ArrayList<Integer>> matrix) {
        if (i - 1 < 0 || j - 1 < 0) return 0;
        else return matrix.get(i - 1).get(j - 1);
    }

}
