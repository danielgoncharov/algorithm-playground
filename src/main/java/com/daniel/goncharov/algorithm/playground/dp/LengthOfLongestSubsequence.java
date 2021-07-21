package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LengthOfLongestSubsequence {

    public int longestSubsequenceLength(final List<Integer> items) {
        if (items.size() == 0) return 0;
        List<Integer> increasingSubsequenceLength = new ArrayList<>();
        initLength(items, increasingSubsequenceLength);
        calculateLength(items, increasingSubsequenceLength);
        List<Integer> reverseItems = new ArrayList<>(items);
        Collections.reverse(reverseItems);
        List<Integer> decreasingSubsequenceLength = new ArrayList<>();
        initLength(reverseItems, decreasingSubsequenceLength);
        calculateLength(reverseItems, decreasingSubsequenceLength);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < items.size(); i++) {
            max = Math.max(
                    max,
                    increasingSubsequenceLength.get(i) + decreasingSubsequenceLength.get(items.size() - 1 - i) - 1
            );
        }
        return max;
    }

    private void initLength(List<Integer> items, List<Integer> increasingSubsequenceLength) {
        increasingSubsequenceLength.clear();
        for (int i = 0; i < items.size(); i++) increasingSubsequenceLength.add(1);
    }

    private void calculateLength(List<Integer> items, List<Integer> increasingSubsequenceLength) {
        for (int i = 1; i < items.size(); i++) {
            for (int j = 0; j < i; j++) {
                int left = items.get(j);
                int right = items.get(i);
                if (right > left) {
                    int leftLength = increasingSubsequenceLength.get(j);
                    int rightLength = increasingSubsequenceLength.get(i);
                    if (leftLength + 1 > rightLength) {
                        increasingSubsequenceLength.set(i, leftLength + 1);
                    }
                }
            }
        }
    }
}
