package com.daniel.goncharov.algorithm.playground.backtracking;


import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int queensCount) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), new ArrayList<>(), queensCount, result);
        return result;
    }

    private void backtrack(
            List<Integer> queensRow,
            List<Integer> queensColumn,
            int number,
            ArrayList<ArrayList<String>> result
    ) {
        if (queensRow.size() == number) {
            result.add(createResult(queensRow, queensColumn, number));
            return;
        }
        for (int row = 0; row < number; row++) {
            if (queensRow.contains(row)) continue;
            for (int column = 0; column < number; column++) {
                if (queensColumn.contains(column)) continue;
                if (isUnderDiagonalAttack(row, column, queensRow, queensColumn)) continue;
                if (hasSkippedTheRow(queensRow, row)) return;
                queensRow.add(row);
                queensColumn.add(column);
                backtrack(queensRow, queensColumn, number, result);
                queensRow.remove(queensRow.size() - 1);
                queensColumn.remove(queensColumn.size() - 1);
            }
        }
    }

    private boolean hasSkippedTheRow(List<Integer> queensRow, int row) {
        if (queensRow.isEmpty()) return false;
        return Math.abs(row - queensRow.get(queensRow.size() - 1)) > 1;
    }

    private ArrayList<String> createResult(List<Integer> queensRow, List<Integer> queensColumn, int number) {
        ArrayList<String> result = new ArrayList<>();
        for (int row = 0; row < number; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            int currentQueenRow = queensRow.get(row);
            int currentQueensColumn = queensColumn.get(row);
            for (int column = 0; column < number; column++) {
                if (row == currentQueenRow && column == currentQueensColumn) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private boolean isUnderDiagonalAttack(
            int row,
            int column,
            List<Integer> queensRow,
            List<Integer> queensColumn) {
        for (int index = 0; index < queensRow.size(); index++) {
            if (Math.abs(row - queensRow.get(index)) == Math.abs(column - queensColumn.get(index)))
                return true;
        }
        return false;
    }
}
