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
        Stack<Integer> stack = new Stack<>();
        int index;
        for (index = 0; index < arrayList.size(); ) {
            if (stack.isEmpty() || arrayList.get(index) >= arrayList.get(stack.peek())) {
                index++;
                stack.add(index);
            } else {
                max = getMax(max, stack, index);
            }
        }
        while (!stack.isEmpty()) {
            max = getMax(max, stack, index);
        }
        return max;
    }

    private int getMax(int max, Stack<Integer> stack, int index) {
        int topOfTheStack = stack.pop();
        if (stack.isEmpty()) {
            return Math.max(max, topOfTheStack * index);
        } else {
            return Math.max(max, topOfTheStack * (index - stack.peek() - 1));
        }
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
