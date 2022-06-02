package com.daniel.goncharov.algorithm.playground.dp;

public class DiceThrow {

    public int findDiceSum(int throwsCount, int maxDice, int goalSum) {

    }

    private int countWays(
            int goalSum,
            int maxDice,
            int throwsCount
    ) {
        if (goalSum == 0) return 1;
        if (goalSum < 0 || throwsCount == 0) return 0;
        int sum = 0;
        for (int i = 1; i <= maxDice; i++) {
            sum += countWays(goalSum - i, maxDice, throwsCount - 1);
        }
        return sum;
    }
}
