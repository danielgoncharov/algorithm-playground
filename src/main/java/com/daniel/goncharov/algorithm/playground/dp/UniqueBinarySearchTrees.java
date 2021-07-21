package com.daniel.goncharov.algorithm.playground.dp;

import java.util.Map;

public class UniqueBinarySearchTrees {

    public int numTrees(int A) {
        return numTreesIterative(A);
    }

    public int numTreesIterative(int limit) {
        int[] dp = new int[limit + 1];
        dp[0] = dp[1] = 1;
        for (int n = 2; n <= limit; n++) {
            for (int root = 1; root <= n; root++) {
                dp[n] += dp[root - 1] * dp[n - root];
            }
        }
        return dp[limit];
    }

    private int numTreesRecursive(
            int left,
            int right,
            Map<Integer, Integer> map
    ) {
        int numberOfElements = right - left + 1;
        if (map.containsKey(numberOfElements)) {
            return map.get(numberOfElements);
        }
        if (left >= right) {
            return 1;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numTreesRecursive(left, i - 1, map) * numTreesRecursive(i + 1, right, map);
        }
        map.put(numberOfElements, sum);
        return sum;
    }
}
