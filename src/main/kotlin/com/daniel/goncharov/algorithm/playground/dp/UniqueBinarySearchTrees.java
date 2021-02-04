package com.daniel.goncharov.algorithm.playground.dp;

public class UniqueBinarySearchTrees {

    public int numTrees(int A) {
        return numTreesRecursive(1, A);
    }

    private int numTreesRecursive(
            int left,
            int right
    ) {
        if (left >= right) {
            return 1;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numTreesRecursive(left, i - 1) * numTreesRecursive(i + 1, right);
        }
        return sum;
    }
}
