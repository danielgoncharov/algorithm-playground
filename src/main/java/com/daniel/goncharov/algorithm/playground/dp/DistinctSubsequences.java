package com.daniel.goncharov.algorithm.playground.dp;

public class DistinctSubsequences {

    public int numDistinct(String a, String b) {
        int[][] table = new int[b.length() + 1][a.length() + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0) {
                    table[i][j] = 1;
                } else if (j == 0) {
                    table[i][j] = 0;
                } else if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    table[i][j] = table[i - 1][j - 1] + table[i][j - 1];
                } else {
                    table[i][j] = table[i][j - 1];
                }
            }
        }
        return table[b.length()][a.length()];
    }
}
