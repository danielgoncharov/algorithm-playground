package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class RepeatingSubSequence {
    public int anytwo(String string) {
        int[][] table = new int[string.length() + 1][string.length() + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }
                if (string.charAt(i - 1) == string.charAt(j - 1) && i!=j) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    continue;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[string.length()][string.length()]>=2 ? 1 : 0;
    }
}
