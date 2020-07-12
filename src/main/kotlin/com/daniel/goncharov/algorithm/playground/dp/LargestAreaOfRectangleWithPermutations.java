package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestAreaOfRectangleWithPermutations {

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        convertToConsequentMatrix(matrix);
        sort(matrix);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            max = Math.max(max, calculateBiggestHistogram(matrix.get(i)));
        }
        return max;
    }

    private int calculateBiggestHistogram(ArrayList<Integer> arrayList) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stackPosition = new Stack<>();
        Stack<Integer> stackHeights = new Stack<>();
        int index;
        for (index = 0; index < arrayList.size(); index++) {
            int currentElement = arrayList.get(index);
            if (stackPosition.isEmpty() || currentElement > stackPosition.peek()) {
                stackPosition.add(index);
                stackHeights.add(currentElement);
                continue;
            }

            while ( <currentElement){
                int topOfTheStack = stackPosition.pop();
                if (stackPosition.isEmpty()) {
                    max = Math.max(max, topOfTheStack * index);
                } else {
                    max = Math.max(max, topOfTheStack * (index - stackPosition.peek() - 1);
                }
            }
            stackPosition.add(currentElement);
        }
        return max;
    }

    private void sort(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            Collections.reverse(matrix.get(i));
        }
    }

    private void convertToConsequentMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int prev = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                int value = matrix.get(j).get(i);
                if (value == 1) {
                    prev++;
                } else {
                    prev = 0;
                }
                set(matrix, j, i, prev);
            }
        }
    }

    private void set(
            ArrayList<ArrayList<Integer>> matrix,
            int i,
            int j,
            int prev
    ) {
        ArrayList<Integer> list = matrix.get(i);
        list.set(j, prev);
        matrix.set(i, list);
    }
}
