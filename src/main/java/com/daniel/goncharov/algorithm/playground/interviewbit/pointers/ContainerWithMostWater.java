package com.daniel.goncharov.algorithm.playground.interviewbit.pointers;

import java.util.ArrayList;

public class ContainerWithMostWater {

    public int maxArea(ArrayList<Integer> input) {
        int left = 0;
        int right = input.size() - 1;
        int area = 0;
        while (left < right) {
            int elementToTheLeft = input.get(left);
            int elementToTheRight = input.get(right);
            area = Math.max(area, Math.min(elementToTheLeft, elementToTheRight) * (right - left));
            if (elementToTheLeft < elementToTheRight) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
