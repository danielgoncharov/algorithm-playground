package com.daniel.goncharov.algorithm.playground.pointers;

import java.util.ArrayList;

public class MinimizeAbsoluteDifference {

    public int solve(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB, ArrayList<Integer> arrayC) {
        int min = Integer.MAX_VALUE;
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexA < arrayA.size() && indexB < arrayB.size() && indexC < arrayC.size()) {
            int elementA = arrayA.get(indexA);
            int elementB = arrayB.get(indexB);
            int elementC = arrayC.get(indexC);
            int minValue = Math.min(Math.min(elementA, elementB), elementC);
            int tryMin = Math.abs(Math.max(Math.max(elementA, elementB), elementC) - minValue);
            if (tryMin < min) min = tryMin;
            if (minValue == elementA) indexA++;
            if (minValue == elementB) indexB++;
            if (minValue == elementC) indexC++;
        }
        return min;

    }
}
