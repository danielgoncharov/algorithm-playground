package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;

public class DungeonPrincess {

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = matrix.size() - 1; i >= 0; i--) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = row.size() - 1; j >= 0; j--) {
                if (i == matrix.size() - 1 && j == row.size() - 1) {
                    setLastItem(row, j);
                } else {
                    setOtherItem(matrix, i, j);
                }
            }
        }
        return matrix.get(0).get(0);

    }

    private void setLastItem(ArrayList<Integer> row, int j) {
        int item = row.get(j);
        if (item <= 0) {
            row.set(j, Math.abs(item) + 1);
        }
    }

    private void setOtherItem(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        ArrayList<Integer> row = matrix.get(i);
        int item = row.get(j);
        int minItem = Math.min(getFromBottom(matrix, i, j), getFromRight(matrix, i, j));
        if (item <= 0) {
            row.set(j, Math.abs(item) + minItem);
        } else if (item - minItem >= 0) {
            row.set(j, 1);
        } else {
            row.set(j, Math.abs(item - minItem));
        }
    }

    private int getFromBottom(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        if (i + 1 == matrix.size()) return Integer.MAX_VALUE;
        else return matrix.get(i + 1).get(j);
    }

    private int getFromRight(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        if (j + 1 == matrix.get(0).size()) return Integer.MAX_VALUE;
        else return matrix.get(i).get(j + 1);
    }
}
