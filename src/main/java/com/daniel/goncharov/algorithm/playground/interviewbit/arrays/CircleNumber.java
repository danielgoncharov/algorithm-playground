package com.daniel.goncharov.algorithm.playground.interviewbit.arrays;

import java.util.ArrayList;

public class CircleNumber {

    private final static int LEFT_TO_RIGHT = 1;
    private final static int TOP_TO_BOTTOM = 2;
    private final static int RIGHT_TO_LEFT = 3;
    private final static int BOTTOM_TO_TOP = 4;


    public ArrayList<ArrayList<Integer>> prettyPrint(int size) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int matrixSize = size * 2 - 1;
        for (int row = 0; row < matrixSize; row++) {
            ArrayList<Integer> matrixRow = new ArrayList<>();
            for (int column = 0; column < matrixSize; column++) {
                matrixRow.add(0);
            }
            matrix.add(matrixRow);
        }
        int startIndex = 0;
        int endIndex = matrixSize;
        int row = startIndex;
        int column = startIndex;
        int direction = LEFT_TO_RIGHT;
        while (startIndex != size) {
            matrix.get(column).set(row, size - startIndex);
            if (direction == LEFT_TO_RIGHT) {
                column++;
            } else if (direction == RIGHT_TO_LEFT) {
                column--;
            } else if (direction == TOP_TO_BOTTOM) {
                row++;
            } else if (direction == BOTTOM_TO_TOP) {
                row--;
            }

            if (column == endIndex) {
                direction = TOP_TO_BOTTOM;
                column--;
            } else if (column < startIndex) {
                direction = BOTTOM_TO_TOP;
                column++;
            } else if (row == endIndex) {
                direction = RIGHT_TO_LEFT;
                row--;
            } else if (row < startIndex) {
                direction = LEFT_TO_RIGHT;
                row++;
            }

            if (row == startIndex && column == startIndex) {
                startIndex++;
                endIndex--;
                row = startIndex;
                column = startIndex;
                direction = LEFT_TO_RIGHT;
            }
        }
        return matrix;
    }
}
