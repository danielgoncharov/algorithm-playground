package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int tillNumber, int combinationCount) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), combinationCount, 0, tillNumber);
        return result;
    }

    private void combine(
            ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> row,
            int combinationCount,
            int currentIndex,
            int indexLimit
    ) {
        if (row.size() == combinationCount) {
            result.add(new ArrayList<>(row));
            return;
        }
        if (currentIndex >= indexLimit) return;
        row.add(currentIndex + 1);
        combine(result, row, combinationCount, currentIndex + 1, indexLimit);
        row.remove(row.size() - 1);
        combine(result, row, combinationCount, currentIndex + 1, indexLimit);
    }
}
