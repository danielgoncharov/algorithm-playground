package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.HashMap;
import java.util.Map;

public class IntersectingChordsCircle {

    public int chordCnt(int chordsNumber) {
        return countChords(0, chordsNumber * 2, new HashMap<>());
    }

    private int countChords(
            int left,
            int right,
            Map<Integer, Integer> memo
    ) {
        if (
                (left == 2 && right == 2) ||
                        (left == 2 && right == 0) ||
                        (left == 0 && right == 2)
        ) return 1;
        return countChords(left, memo) + countChords(right, memo);
    }

    private int countChords(int dots, Map<Integer, Integer> memo) {
        if (memo.containsKey(dots)) return memo.get(dots);
        int sum = 0;
        for (int index = 0; index < dots - 1; index += 2) {
            sum += countChords(index, dots - index - 2, memo);
        }
        memo.put(dots, sum);
        return sum;
    }
}
