package com.daniel.goncharov.algorithm.playground.binary.search;


import java.util.ArrayList;

public class PainterPartitionProblem {

    public int paint(int numberOfPainter, int speed, ArrayList<Integer> board) {
        int min = findMin(board);
        int max = findMax(board);
        while (min < max) {
            int mid = (max + min) / 2;
            int requiredNumbered = findAmountOfPainters(mid, board);
            if (requiredNumbered > numberOfPainter) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return (min / speed) ;
    }

    private int findAmountOfPainters(int maxLengthPerPainter, ArrayList<Integer> board) {
        int total = 0;
        int numberOfPainters = 1;
        for (int boardPeace : board) {
            total += boardPeace;
            if (total > maxLengthPerPainter) {
                total = boardPeace;
                numberOfPainters++;
            }
        }
        return numberOfPainters;
    }

    private int findMax(ArrayList<Integer> board) {
        int total = 0;
        for (int boardPeace : board) {
            total += boardPeace;
        }
        return total;
    }

    private int findMin(ArrayList<Integer> board) {
        int max = Integer.MIN_VALUE;
        for (int boardPeace : board) {
            if (boardPeace > max) max = boardPeace;
        }
        return max;
    }
}
