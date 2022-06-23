package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

    public int isValidSudoku(final List<String> board) {
        List<Map<Character, Integer>> rows = createList();
        List<Map<Character, Integer>> columns = createList();
        List<List<Map<Character, Integer>>> squares = createMap();

        for (int index = 0; index < board.size(); index++) {
            String row = board.get(index);
            Map<Character, Integer> rowMap = new HashMap<>();
            rows.add(rowMap);
            List<Map<Character, Integer>> squareRow = squares.get(index / 3);
            for (int columnIndex = 0; columnIndex < row.length(); columnIndex++) {
                Character character = row.charAt(columnIndex);
                if (character == '.') continue;
                Map<Character, Integer> squareMap = squareRow.get(columnIndex / 3);
                Map<Character, Integer> column = columns.get(columnIndex);
                if (breaksBoard(rowMap, character)
                        || breaksBoard(column, character)
                        || breaksBoard(squareMap, character)) return 0;
            }
        }
        return 1;
    }

    private List<Map<Character, Integer>> createList() {
        List<Map<Character, Integer>> result = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            result.add(new HashMap<>());
        }
        return result;
    }

    private List<List<Map<Character, Integer>>> createMap() {
        List<List<Map<Character, Integer>>> result = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            List<Map<Character, Integer>> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(new HashMap<>());
            }
            result.add(row);
        }
        return result;
    }

    private boolean breaksBoard(Map<Character, Integer> rowMap, Character character) {
        if (rowMap.containsKey(character)) {
            return true;
        } else {
            rowMap.put(character, 1);
            return false;
        }
    }
}