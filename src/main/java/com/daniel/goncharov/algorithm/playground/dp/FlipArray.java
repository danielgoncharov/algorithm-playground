package com.daniel.goncharov.algorithm.playground.dp;

import java.util.Arrays;
import java.util.List;

public class FlipArray {

    public int solve(final List<Integer> a) {
        int numbers[] = new int[a.size()];
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) sum += numbers[i];
        int dp[] = new int[sum / 2 + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j - numbers[i] >= 0 && dp[j - numbers[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - numbers[i]] + 1);
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != Integer.MAX_VALUE) {
                return dp[i];
            }
        }

        return 0;
    }

}
