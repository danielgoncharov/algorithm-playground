package com.daniel.goncharov.algorithm.playground.dp;

import java.util.List;

public class BestTimeToBuyAndSellStocks {

    public int maxProfit(final List<Integer> dayPrices) {
        return maxProfitRecursive(dayPrices, 0, 0, false);
    }

    private int maxProfitRecursive(
            List<Integer> dayPrices,
            int currentPosition,
            int profit,
            Boolean inTransaction
    ) {
        if (currentPosition == dayPrices.size()) return 0;
        int buy = 0;
        if (!inTransaction)
            buy = maxProfitRecursive(
                    dayPrices,
                    currentPosition + 1,
                    profit - dayPrices.get(currentPosition),
                    true
            );
        int sell = maxProfitRecursive(
                dayPrices,
                currentPosition + 1,
                profit + dayPrices.get(currentPosition),
                false
        );
        int doNothing = maxProfitRecursive(
                dayPrices,
                currentPosition + 1,
                profit,
                inTransaction
        );
        return max(buy, sell, doNothing);
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
