package com.daniel.goncharov.algorithm.playground.binary.search;

import java.util.List;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    int find(List<Integer> array, Integer element) {
        int left = 0;
        int right = array.size() - 1;
        int middle = array.size() / 2;
        while (right - left > 1) {
            if (array.get(middle).equals(element)) {
                return middle;
            } else if (array.get(middle) > element) {
                right = middle - 1;
                middle = (left + right) / 2;
            } else if (array.get(middle) < element) {
                left = middle + 1;
                middle = (left + right) / 2;
            }
        }
        Integer leftElement = array.get(left);
        Integer rightElement = array.get(right);
        if (element.equals(leftElement)) {
            return left;
        } else if (element.equals(rightElement)) {
            return right;
        } else {
            return NOT_FOUND;
        }
    }

}
