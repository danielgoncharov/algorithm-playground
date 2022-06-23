package com.daniel.goncharov.algorithm.playground.interviewbit.backtracking;

import java.util.ArrayList;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, numbers);
        return result;
    }

    private void backtrack(ArrayList<Integer> permutation,
                           ArrayList<ArrayList<Integer>> result,
                           ArrayList<Integer> numbers) {
        if (permutation.size() == numbers.size()) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int index = 0; index < numbers.size(); index++) {
            Integer currentElement = numbers.get(index);
            if (permutation.contains(currentElement)) continue;
            permutation.add(currentElement);
            backtrack(permutation, result, numbers);
            permutation.remove(permutation.size() - 1);
        }
    }
}
