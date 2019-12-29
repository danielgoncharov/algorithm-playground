package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> input, int targetSum) {
        ArrayList<Integer> numbers = new ArrayList<>(new HashSet<>(input));
        Collections.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combine(
                result,
                new ArrayList<>(),
                numbers,
                targetSum,
                0,
                0
        );
        return result;
    }

    private void combine(
            ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> row,
            ArrayList<Integer> numbers,
            int targetSum,
            int currentIndex,
            int currentSum
    ) {
        if (currentIndex == numbers.size()) return;
        if (currentSum == targetSum) {
            result.add(new ArrayList<>(row));
            return;
        }
        if (currentSum > targetSum) return;
        int currentNumber = numbers.get(currentIndex);
        row.add(currentNumber);
        combine(
                result,
                row,
                numbers,
                targetSum,
                currentIndex,
                currentSum + currentNumber
        );
        row.remove(row.size() - 1);
        combine(
                result,
                row,
                numbers,
                targetSum,
                currentIndex + 1,
                currentSum
        );
    }
}
