package com.daniel.goncharov.algorithm.playground.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public String getPermutation(int total, int kth) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> numbers = new ArrayList<>();
        long factorial = 1;
        for (int number = 1; number <= total; number++) {
            numbers.add(String.valueOf(number));
            factorial *= number;
        }
        solve(total, factorial, kth - 1, stringBuilder, numbers);
        return stringBuilder.toString();
    }

    private void solve(
            int total,
            long factorial,
            int kth,
            StringBuilder resultBuilder,
            List<String> numbers
    ) {
        if (numbers.isEmpty()) return;
        long nextFactorial = factorial / total ;
        int index = (int) (kth / nextFactorial);
        int nextK = (int) (kth % nextFactorial);
        String number = numbers.get(index);
        numbers.remove(index);
        resultBuilder.append(number);
        solve(total - 1, nextFactorial, nextK, resultBuilder, numbers);
    }
}
