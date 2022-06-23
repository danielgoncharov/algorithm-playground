package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;

public class KingdomWar {

    public int solve(ArrayList<ArrayList<Integer>> villageMap) {
        int max = Integer.MIN_VALUE;
        for (int i = villageMap.size() - 1; i >= 0; i--) {
            ArrayList<Integer> row = villageMap.get(i);
            for (int j = row.size() - 1; j >= 0; j--) {
                int maxForSell = row.get(j)
                        + getBottom(villageMap, i, j)
                        + getRight(villageMap, i, j)
                        - getDiagonal(villageMap, i, j);
                max = Math.max(max, maxForSell);
                row.set(j, maxForSell);
            }
        }
        return max;
    }

    private int getDiagonal(ArrayList<ArrayList<Integer>> villageMap, int i, int j) {
        return getItem(villageMap, i + 1, j + 1);
    }

    private int getRight(ArrayList<ArrayList<Integer>> villageMap, int i, int j) {
        return getItem(villageMap, i, j + 1);
    }

    private int getBottom(ArrayList<ArrayList<Integer>> villageMap, int i, int j) {
        return getItem(villageMap, i + 1, j);
    }


    private int getItem(ArrayList<ArrayList<Integer>> villageMap, int i, int j) {
        if (i == villageMap.size() || j == villageMap.get(0).size()) return 0;
        else return villageMap.get(i).get(j);
    }


}
