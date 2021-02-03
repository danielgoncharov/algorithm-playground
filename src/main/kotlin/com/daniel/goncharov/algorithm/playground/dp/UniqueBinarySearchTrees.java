package com.daniel.goncharov.algorithm.playground.dp;

public class UniqueBinarySearchTrees {

    public int numTrees(int A) {
        if (A == 2) return 2;
        return numTreesRecursive(1, A);
    }

    private int numTreesRecursive(
            int left,
            int right
    ) {
        if (left > right || left == 0 || right - left == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += numTreesRecursive(left - 1, i) * numTreesRecursive(i + 1, right);
        }
        return sum;
    }
}
