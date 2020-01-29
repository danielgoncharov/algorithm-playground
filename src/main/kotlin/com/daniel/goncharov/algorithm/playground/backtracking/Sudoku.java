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
            int rowIndex,
            int columnIndex) {
        ArrayList<Character> lastRow = board.get(board.size() - 1);
        if (columnIndex == lastRow.size()) {
            columnIndex = 0;
            rowIndex++;
        }
        if (rowIndex == lastRow.size()) {
            isSolutionFound = true;
            return;
        }
        ArrayList<Character> row = board.get(rowIndex);
        Character character = row.get(columnIndex);
        if (character != '.') {
            backtrack(board, rowIndex, columnIndex + 1);
            return;
        }
        for (int number = 1; number < 10; number++) {
            if (!isUnique(number, board, rowIndex, columnIndex)) {
                if (number == 9) return;
                else continue;
            }
            row.set(columnIndex, (char) ('0' + number));
            backtrack(board, rowIndex, columnIndex + 1);
            if (isSolutionFound) return;
            int value = row.get(columnIndex);
            row.set(columnIndex, '.');
            if (value == '9') {
                return;
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
        numbersMap.add((char) ('0' + number));
        for (int index = 0; index < row.size(); index++) {
            Character character = board.get(index).get(columnIndex);
            if (character == '.') continue;
            if (numbersMap.contains(character)) return false;
            numbersMap.add(character);
        }

        numbersMap.clear();
        numbersMap.add((char) ('0' + number));
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
