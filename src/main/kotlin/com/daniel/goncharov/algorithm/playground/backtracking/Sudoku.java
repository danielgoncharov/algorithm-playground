package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private boolean isSolutionFound = false;

    public void solveSudoku(ArrayList<ArrayList<Character>> board) {
        backtrack(board, 0, 0);
    }

    private void backtrack(
            ArrayList<ArrayList<Character>> board,
            int rowStart,
            int columnStart) {
        if (rowStart == board.size() - 1 && columnStart == board.get(rowStart).size() - 1) {
            isSolutionFound = true;
            return;
        }
        for (int rowIndex = rowStart; rowIndex < board.size(); rowIndex++) {
            if (isSolutionFound) return;
            ArrayList<Character> row = board.get(rowIndex);
            for (int columnIndex = columnStart; columnIndex < row.size(); columnIndex++) {
                if (isSolutionFound) return;
                Character character = row.get(columnIndex);
                if (character != '.') continue;
                for (int number = 1; number < 10; number++) {
                    if (!isUnique(number, board, rowIndex, columnIndex)) continue;
                    row.set(columnIndex, (char) ('0' + number));
                    backtrack(board, rowIndex, columnIndex);
                    if (isSolutionFound) return;
                    row.set(columnIndex, '.');
                }
            }
        }
    }

    private boolean isUnique(int number,
                             ArrayList<ArrayList<Character>> board,
                             int rowIndex,
                             int columnIndex) {
        List<Character> numbersMap = new ArrayList<>();
        numbersMap.add((char) ('0' + number));
        ArrayList<Character> row = board.get(rowIndex);
        for (int index = 0; index < row.size(); index++) {
            Character character = row.get(index);
            if (character == '.') continue;
            if (numbersMap.contains(character)) return false;
            numbersMap.add(character);
        }
        numbersMap.clear();
        numbersMap.add((char) number);
        for (int index = 0; index < row.size(); index++) {
            Character character = board.get(index).get(columnIndex);
            if (character == '.') continue;
            if (numbersMap.contains(character)) return false;
            numbersMap.add(character);
        }
        numbersMap.clear();
        numbersMap.add((char) number);

        int startRowIndex = (rowIndex / 3) * 3;
        int startColumnIndex = (columnIndex / 3) * 3;
        for (int rowI = startRowIndex; rowI < startRowIndex + 3; rowI++) {
            row = board.get(rowI);
            for (int columnI = startColumnIndex; columnI < startColumnIndex + 3; columnI++) {
                Character character = row.get(columnI);
                if (character == '.') continue;
                if (numbersMap.contains(character)) return false;
                numbersMap.add(character);
            }
        }

        return true;
    }

}
