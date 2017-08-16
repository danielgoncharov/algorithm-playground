package com.daniel.goncharov.algorithm.playground.sort.merge;

import java.util.Arrays;

public class MergeSort {

    int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        if (array.length == 2) {
            if (array[0] < array[1]) {
                swap(array);
            }
            return array;
        }

        int separatorIndex = array.length / 2;
        int[] firstPart = Arrays.copyOfRange(array, 0, separatorIndex); //always 1 bigger than second
        int[] secondPart = Arrays.copyOfRange(array, separatorIndex, array.length);

        int[] sortedFirstPart = mergeSort(firstPart);
        int[] sortedSecondPart = mergeSort(secondPart);
        int[] mergedArray = new int[array.length];

        int firstIndex = 0;
        int secondIndex = 0;
        while ((firstIndex + secondIndex) != array.length) {

            if (firstIndex == separatorIndex) {
                mergedArray[firstIndex + secondIndex] = sortedSecondPart[secondIndex];
                secondIndex++;
                continue;
            }

            if (secondIndex == array.length - separatorIndex) {
                mergedArray[firstIndex + secondIndex] = sortedFirstPart[firstIndex];
                firstIndex++;
                continue;
            }

            if (sortedFirstPart[firstIndex] < sortedSecondPart[secondIndex]) {
                mergedArray[firstIndex + secondIndex] = sortedSecondPart[secondIndex];
                secondIndex++;
            } else {
                mergedArray[firstIndex + secondIndex] = sortedFirstPart[firstIndex];
                firstIndex++;
            }

        }
        return mergedArray;
    }

    private void swap(int[] array) {
        int buffer = array[0];
        array[0] = array[1];
        array[1] = buffer;
    }

}
