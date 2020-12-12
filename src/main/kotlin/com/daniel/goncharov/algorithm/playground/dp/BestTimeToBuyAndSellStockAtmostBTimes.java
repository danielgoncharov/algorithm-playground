package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStockAtmostBTimes {

    public int solve(ArrayList<Integer> prices, int transactions) {
        int[][] diff = new int[transactions + 1][prices.size() + 1];
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length; j++) {
                diff[i][j] = Math.max(
                        diff[i - 1][j - 1] - prices.get(j - 1),
                        j == 1 ? Integer.MIN_VALUE : diff[i][j - 1]
                );
            }
        }

        int max = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length - 1; j++) {
                max = Math.max(diff[i][j] + prices.get(j), max);
            }
        }
        return max;

    }
}
