package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class NDigitNumbersWithdigitSumS {

    public int solve(int digitNumber, int sum) {
        return solveRec(1, 0, 0, digitNumber, sum, new ArrayList<>());
    }

    private int solveRec(
            int start,
            int count,
            int currentSum,
            int digitNumber,
            int sum,
            ArrayList<Integer> list
    ) {
        if (currentSum == sum) return 1;
        if (currentSum > sum) return 0;
        if (count >= digitNumber) return 0;

        int ways = 0;
        for (int index = start; index <= 9; index++) {
            list.add(index);
            ways += solveRec(
                    0,
                    count + 1,
                    currentSum + index,
                    digitNumber,
                    sum,
                    list
            );
            list.remove(list.size() - 1);
        }
        return ways % 1000000007;
    }
}
