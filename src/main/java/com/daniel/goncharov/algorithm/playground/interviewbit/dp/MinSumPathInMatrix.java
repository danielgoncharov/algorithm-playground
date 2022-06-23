package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;

public class MinSumPathInMatrix {

    public int minPathSum(ArrayList<ArrayList<Integer>> matrix) {
        int min = matrix.get(0).get(0);
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if(i==0 && j==0) continue;
                int fromLeft = getFromleft(matrix, i, j);
                int fromTop = getFromTop(matrix, i, j);
                int valueToSet = Math.min(fromLeft, fromTop) + row.get(j);
                row.set(j, valueToSet);
                min = valueToSet;
            }
        }
        return min;
    }

    private int getFromTop(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        if (i - 1 < 0) return Integer.MAX_VALUE;
        else return matrix.get(i - 1).get(j);
    }

    private int getFromleft(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        if (j - 1 < 0) return Integer.MAX_VALUE;
        else return matrix.get(i).get(j - 1);
    }
}
