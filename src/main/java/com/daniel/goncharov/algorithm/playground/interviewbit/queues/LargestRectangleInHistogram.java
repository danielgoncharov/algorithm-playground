package com.daniel.goncharov.algorithm.playground.interviewbit.queues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> histograms) {
        Stack<Integer> indexesStack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < histograms.size(); index++) {
            int currentElement = histograms.get(index);
            if (currentElement < min) min = currentElement;
            while (!indexesStack.isEmpty() && currentElement < histograms.get(indexesStack.peek())) {
                int stackTopIndex = indexesStack.pop();
                int rightIndex = index;
                int leftIndex = indexesStack.isEmpty() ? -1 : indexesStack.peek();
                max = Math.max(max, (rightIndex - leftIndex - 1) * histograms.get(stackTopIndex));
            }
            indexesStack.push(index);
        }
        max = Math.max(min * histograms.size(), max);
        int size = histograms.size();
        while (!indexesStack.isEmpty()) {
            int currentIndex = indexesStack.pop();
            int area = histograms.get(currentIndex) * (indexesStack.empty() ? size : size - indexesStack.peek() - 1);
            max= Math.max(area, max);
        }
        return max;

    }
}
