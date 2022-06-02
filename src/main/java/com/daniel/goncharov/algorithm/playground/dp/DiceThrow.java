package com.daniel.goncharov.algorithm.playground.dp;

public class DiceThrow {

    public int findDiceSum(int throwsCount, int maxDice, int goalSum) {
        int[][] cache = new int[throwsCount + 1][goalSum + 1];
        for (int i = 0; i < cache.length; i++) {
            int[] row = cache[i];
            for (int j = 0; j < row.length; j++) {
                row[j] = -1;
            }
        }
        return countWays(goalSum, maxDice, throwsCount, cache);
    }

    private int countWays(
            int goalSum,
            int maxDice,
            int throwsCount,
            int[][] cache
    ) {
        if (goalSum == 0) return throwsCount == 0 ? 1 : 0;
        if (goalSum < 0 || throwsCount == 0) return 0;
        if (cache[throwsCount][goalSum] != -1) return cache[throwsCount][goalSum];
        int sum = 0;
        for (int i = 1; i <= maxDice; i++) {
            sum = sum % 1000000007 + countWays(goalSum - i, maxDice, throwsCount - 1, cache);
        }
        cache[throwsCount][goalSum] = sum;
        return sum;
    }
}
