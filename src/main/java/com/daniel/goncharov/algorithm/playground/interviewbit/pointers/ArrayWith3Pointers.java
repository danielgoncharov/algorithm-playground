package com.daniel.goncharov.algorithm.playground.interviewbit.pointers;

import java.util.List;

public class ArrayWith3Pointers {
    public int minimize(final List<Integer> arrayA,
                        final List<Integer> arrayB,
                        final List<Integer> arrayC) {
        int output = Integer.MAX_VALUE;
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexA < arrayA.size() &&
                indexB < arrayB.size() &&
                indexC < arrayC.size()) {
            int aElement = arrayA.get(indexA);
            int bElement = arrayB.get(indexB);
            int cElement = arrayC.get(indexC);
            int ab = Math.abs(aElement - bElement);
            int bc = Math.abs(bElement - cElement);
            int ca = Math.abs(cElement - aElement);
            int max = Math.max(Math.max(ab, bc), ca);
            if (max < output) {
                output = max;
            }
            int min;
            if (max == ab) {
                min = Math.min(aElement, bElement);
            } else if (max == bc) {
                min = Math.min(cElement, bElement);
            } else {
                min = Math.min(cElement, aElement);
            }
            if (min == aElement) {
                indexA++;
            } else if (min == bElement) {
                indexB++;
            } else {
                indexC++;
            }
        }
        return output;
    }
}
