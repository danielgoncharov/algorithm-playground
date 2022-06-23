package com.daniel.goncharov.algorithm.playground.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> numbers, int targetSum) {
        Collections.sort(numbers);
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        combine(result, new ArrayList<>(), numbers, targetSum, 0, 0);
        return new ArrayList<>(result);
    }

    private void combine(
            HashSet<ArrayList<Integer>> result,
            ArrayList<Integer> row,
            ArrayList<Integer> numbers,
            int targetSum,
            int currentIndex,
            int currentSum
    ) {
        if (currentIndex == numbers.size()) {
            return;
        }
        if (currentSum > targetSum) {
            return;
        }

        int currentNumber = numbers.get(currentIndex);
        row.add(currentNumber);
        if (currentSum + currentNumber == targetSum) {
            result.add(new ArrayList<>(row));
            goRight(result, row, numbers, targetSum, currentIndex, currentSum);
            return;
        }

        combine(result, row, numbers, targetSum, currentIndex + 1, currentSum + currentNumber);
        goRight(result, row, numbers, targetSum, currentIndex, currentSum);
    }

    private void goRight(HashSet<ArrayList<Integer>> result, ArrayList<Integer> row, ArrayList<Integer> numbers, int targetSum, int currentIndex, int currentSum) {
        row.remove(row.size() - 1);
        combine(result, row, numbers, targetSum, currentIndex + 1, currentSum);
    }
}
