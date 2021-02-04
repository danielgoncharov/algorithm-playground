package com.daniel.goncharov.algorithm.playground.dp;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public int numTrees(int A) {
        Map<Integer, Integer> map = new HashMap<>();
        return numTreesRecursive(1, A, map);
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
