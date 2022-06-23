package com.daniel.goncharov.algorithm.playground.interviewbit.pointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> left, final List<Integer> right) {
        int indexLeft = 0;
        int indexRight = 0;
        ArrayList<Integer> intersection = new ArrayList<>();
        while (indexLeft < left.size() && indexRight < right.size()) {
            Integer leftElement = left.get(indexLeft);
            Integer rightElement = right.get(indexRight);
            if (leftElement < rightElement) {
                indexLeft++;
            } else if (leftElement > rightElement) {
                indexRight++;
            } else {
                intersection.add(leftElement);
                indexLeft++;
                indexRight++;
            }
        }
        return intersection;
    }
}
