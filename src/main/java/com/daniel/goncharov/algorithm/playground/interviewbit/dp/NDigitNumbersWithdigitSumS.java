package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class NDigitNumbersWithdigitSumS {

    public int solve(int A, int B) {
        int[][] l = new int[A + 1][B + 1];

        for (int j = 1; j <= 9 && j <= B; j++) {
            l[1][j] = 1;
        }

        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                int x = j - 10;
                long val = (long) l[i][j - 1] + (long) l[i - 1][j];
                if (x > 0)
                    val -= (long) l[i - 1][x];
                if (val < 0)
                    val += 1000000007;
                l[i][j] = (int) (val % (long) 1000000007);
            }
        }
        return l[A][B];
    }
}
