package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipArray {

    public int solve(List<Integer> a) {
        List<Integer> numbers = new ArrayList<>(a);
        Collections.sort(numbers);
        int sum = 0;
        for (Integer i : numbers) sum += i;
        int[][] cache = new int[numbers.size() + 1][sum / 2 + 1];
        int[][] minSum = new int[numbers.size() + 1][sum / 2 + 1];
        for (int i = 0; i < cache.length; i++) {
            int[] column = cache[i];
            for (int j = 0; j < column.length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                    minSum[i][j] = 0;
                    continue;
                }
                int reminder = j - numbers.get(i - 1);
                if (reminder < 0) {
                    cache[i][j] = cache[i - 1][j];
                    minSum[i][j] = minSum[i - 1][j];
                } else if (minSum[i - 1][j] > numbers.get(i - 1) + minSum[i - 1][reminder]) {
                    cache[i][j] = cache[i - 1][j];
                    minSum[i][j] = minSum[i - 1][j];
                } else {
                    cache[i][j] = 1 + cache[i - 1][reminder];
                    minSum[i][j] = numbers.get(i - 1) + minSum[i - 1][reminder];
                }

            }
        }
        return cache[numbers.size()][sum / 2];
    }

}
