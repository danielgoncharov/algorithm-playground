package com.daniel.goncharov.algorithm.playground.dp;

import java.util.List;

public class BestTimeToBuyAndSellStocks {

    public int maxProfit(final List<Integer> dayPrices) {
        return maxProfitRecursive(
                dayPrices,
                0,
                0,
                false
        );
    }

    private int maxProfitRecursive(
            List<Integer> dayPrices,
            int currentPosition,
            int profit,
            Boolean inTransaction
    ) {
        if (currentPosition == dayPrices.size()) return 0;

        int result;
        if (inTransaction) {
            //sell
            result = maxProfitRecursive(
                    dayPrices,
                    currentPosition + 1,
                    profit + dayPrices.get(currentPosition),
                    false
            );
        } else {
            //buy
            result = maxProfitRecursive(
                    dayPrices,
                    currentPosition + 1,
                    profit - dayPrices.get(currentPosition),
                    true
            );
        }
        int doNothing = maxProfitRecursive(
                dayPrices,
                currentPosition + 1,
                profit,
                inTransaction
        );
        return Math.max(result, doNothing);
    }

}
