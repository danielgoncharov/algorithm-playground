package com.daniel.goncharov.algorithm.playground.sort;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int originalLeft, int originalRight) {
        if (originalRight - originalLeft == 0) {
            return;
        } else if (originalRight - originalLeft == 1 && array[originalLeft] > array[originalRight]) {
            swap(array, originalLeft, originalRight);
            return;
        }
        int pivot = calculatePivot(originalLeft, originalRight);
        int left = originalLeft;
        int right = originalRight;
        while (right - left > 0) {
            if (left != pivot) {
                if (array[left] <= array[pivot]) {
                    left++;
                } else {
                    swap(array, left, pivot);
                    pivot = left;
                }
            }
            if (right != pivot) {
                if (array[right] >= array[pivot]) {
                    right--;
                } else {
                    swap(array, right, pivot);
                    pivot = right;
                }
            }
        }

        if (pivot > originalLeft) {
            quickSort(array, originalLeft, pivot - 1);
        }
        if (pivot < originalRight) {
            quickSort(array, pivot + 1, originalRight);
        }
    }


    private int calculatePivot(int originalLeft, int originalRight) {
        return originalLeft;
    }

    private void swap(int[] array, int left, int right) {
        int buffer = array[left];
        array[left] = array[right];
        array[right] = buffer;
    }
}
