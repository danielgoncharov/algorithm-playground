package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public String getPermutation(int total, int kth) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> numbers = new ArrayList<>();
        for (int number = 1; number <= total; number++) {
            numbers.add(String.valueOf(number));
        }
        solve(total, kth - 1, stringBuilder, numbers);
        return stringBuilder.toString();
    }

    private void solve(
            int total,
            int kth,
            StringBuilder resultBuilder,
            List<String> numbers
    ) {
        if (numbers.isEmpty()) return;
        int indexToPull = kth;
        int reminder = 0;
        for (int number = total - 1; number > 1; number--) {
            reminder = indexToPull % number;
            indexToPull /= number;
            indexToPull += reminder;
            if (indexToPull == 0) break;
        }
        if (reminder > 0) indexToPull -= reminder;

        String number = numbers.get(indexToPull);
        numbers.remove(indexToPull);
        resultBuilder.append(number);
        int nextK = reminder;
        solve(total - 1, nextK, resultBuilder, numbers);
    }
}
