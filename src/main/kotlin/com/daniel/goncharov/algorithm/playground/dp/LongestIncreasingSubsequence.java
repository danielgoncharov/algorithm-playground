package com.daniel.goncharov.algorithm.playground.dp;

import java.util.List;

public class LongestIncreasingSubsequence {

    public int lis(final List<Integer> numbers) {
        int size = 0;
        int[] memory = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers.get(j) < currentNumber) {
                    max = Math.max(max, memory[j]);
                }
            }
            memory[i] = max + 1;
            size = Math.max(size, memory[i]);
        }
        return size;
    }
}
