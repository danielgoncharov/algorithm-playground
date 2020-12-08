package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestTimeToBuyAndSellStockAtmostBTimes {

    public int solve(ArrayList<Integer> stocks, int transactions) {
        int[][] profits = new int[stocks.size()][stocks.size()];
        for (int i = 0; i < stocks.size(); i++) {
            for (int j = i; j < stocks.size(); j++) {
                if (i == j) {
                    profits[i][j] = 0;
                } else {
                    profits[i][j] = stocks.get(j) - stocks.get(i);
                }
            }
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        int maxSum = 0;
        int line = 1;
        int i = 0;
        int j = 1;
        while (line != stocks.size()) {
            maxHeap.add(profits[i][j]);
            i++;
            j++;
            if (j == stocks.size()) {
                maxSum = Math.max(maxSum, getMaxSum(maxHeap, transactions));
                line++;
                i = 0;
                j = line;
            }
        }

        return maxSum;
    }

    private int getMaxSum(PriorityQueue<Integer> maxHeap, int transactions) {
        int max = 0;
        while (transactions != 0) {
            if (maxHeap.isEmpty()) break;
            int element = maxHeap.poll();
            if (element >= 0) {
                max += element;
            }
            transactions--;
        }
        maxHeap.clear();
        return max;
    }
}
