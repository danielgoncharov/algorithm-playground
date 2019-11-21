package com.daniel.goncharov.algorithm.playground.stacks.queues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> histograms) {
        Stack<Integer> indexesStack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < histograms.size(); index++) {
            int currentElement = histograms.get(index);
            int stackTop = histograms.get(indexesStack.peek());
            while (!indexesStack.isEmpty() && currentElement < stackTop) {
                stackTop = indexesStack.pop();
                int rightIndex = index;
                int leftIndex = indexesStack.isEmpty() ? -1 : indexesStack.peek();
                max = Math.max(max, (rightIndex - leftIndex - 1) * stackTop);
            }
            indexesStack.push(index);
        }
        return max;
    }
}
