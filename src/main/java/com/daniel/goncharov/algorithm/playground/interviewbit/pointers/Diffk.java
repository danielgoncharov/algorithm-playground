package com.daniel.goncharov.algorithm.playground.interviewbit.pointers;

import java.util.ArrayList;

public class Diffk {

    public int diffPossible(ArrayList<Integer> input, int expectedDiff) {
        if (input.size() < 2) return 0;
        int left = 0;
        int right = 1;
        do {
            int diff = Math.abs(input.get(left) - input.get(right));
            if (diff == expectedDiff) return 1;
            if (diff < expectedDiff) {
                right++;
                continue;
            }
            if (right - left == 1) {
                left++;
                right++;
                continue;
            }
            left++;
        } while (right < input.size());
        return 0;
    }
}
