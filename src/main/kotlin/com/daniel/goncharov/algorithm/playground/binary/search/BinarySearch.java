package com.daniel.goncharov.algorithm.playground.binary.search;

import java.util.List;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    int find(List<Integer> array, int element) {
        int left = 0;
        int right = array.size() - 1;
        int middle;
        while (left<=right) {
            middle = (left + right) / 2;
            if (array.get(middle)==element) {
                return middle;
            } else if (array.get(middle) > element) {
                right = middle - 1;
            } else if (array.get(middle) < element) {
                left = middle + 1;

            }
        }
        return NOT_FOUND;
    }

}
