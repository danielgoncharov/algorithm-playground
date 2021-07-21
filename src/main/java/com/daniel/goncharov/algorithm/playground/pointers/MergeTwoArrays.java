package com.daniel.goncharov.algorithm.playground.pointers;

import java.util.ArrayList;

public class MergeTwoArrays {

    public void merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (; rightIndex < right.size(); rightIndex++) {
            Integer rightElement = right.get(rightIndex);
            while (left.get(leftIndex) < rightElement) {
                leftIndex++;
                if (leftIndex == left.size()) break;
            }
            left.add(leftIndex, rightElement);
        }
        left.addAll(right.subList(rightIndex,right.size()));
    }
}
