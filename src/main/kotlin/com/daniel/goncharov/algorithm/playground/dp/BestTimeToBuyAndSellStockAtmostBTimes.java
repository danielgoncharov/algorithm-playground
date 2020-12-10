package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

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

        int lastJStart = profits.length - 1;
        int i = profits.length - 2;
        int j = lastJStart;
        int maxSum = 0;
        while (i >= 0) {
            int lastMax = j + 1 < profits.length ? profits[j][j + 1] : 0;
            profits[i][j] = Math.max(0, profits[i][j]) + lastMax;
            maxSum = Math.max(profits[i][j], maxSum);
            j++;
            if (j == profits.length) {
                i--;
                lastJStart--;
                j = lastJStart;
            }
        }

        return maxSum;
    }
}
