package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        combine(result, new ArrayList<>(), numbers, 0);
        return new ArrayList<>(result);
    }

    private void combine(
            ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> row,
            ArrayList<Integer> numbers,
            int currentIndex
    ) {
        if (currentIndex == numbers.size()) return;
        int currentNumber = numbers.get(currentIndex);
        row.add(currentNumber);
        if(!result.contains(row)) result.add(new ArrayList<>(row));
        combine(result, row, numbers, currentIndex + 1);
        row.remove(row.size() - 1);
        combine(result, row, numbers, currentIndex + 1);
    }
}