package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class DiceRolls {

    public int solve(int sum) {
        int[] memory = new int[sum + 1];
        memory[0] = 0;
        for (int i = 1; i <= Math.min(sum, 6); i++) {
            memory[i] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= 6; j++) {
                int previous = i - j;
                if (previous < 0) continue;
                memory[i] += memory[previous] % 1000000007;
            }
        }
        return memory[sum];
    }

    private int countWaysRec(int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += countWaysRec(sum - i);
        }
        return count;
    }
}
