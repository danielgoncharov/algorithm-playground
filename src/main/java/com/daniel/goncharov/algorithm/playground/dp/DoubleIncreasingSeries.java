package com.daniel.goncharov.algorithm.playground.dp;

public class DoubleIncreasingSeries {

    public int solve(int maxElement, int seqLength) {
        int count = 0;
        for (int i = 1; i <= maxElement; i++) {
            count += countSeq(i, maxElement, 1, seqLength);
        }
        return count;
    }

    private int countSeq(
            int currentElement,
            int maxElement,
            int sqCounter,
            int seqLength
    ) {
        if (sqCounter == seqLength) return 1;
        if (currentElement * 2 > maxElement) return 0;
        int count = 0;
        for (int i = currentElement * 2; i <= maxElement; i++) {
            count += countSeq(i, maxElement, sqCounter + 1, seqLength);
        }
        return count;
    }
}
