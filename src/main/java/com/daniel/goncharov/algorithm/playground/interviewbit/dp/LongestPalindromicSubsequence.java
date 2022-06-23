package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class LongestPalindromicSubsequence {

    public int solve(String inputString) {
        String a = inputString;
        String b = new StringBuilder(inputString).reverse().toString();
        int[][] table = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < table.length; i++) {
            int row[] = table[i];
            for (int j = 0; j < row.length; j++) {
                if (i == 0 || j == 0) {
                    row[j] = 0;
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    row[j] = table[i - 1][j - 1] + 1;
                    continue;
                } else {
                    row[j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[a.length()][b.length()];
    }
}
