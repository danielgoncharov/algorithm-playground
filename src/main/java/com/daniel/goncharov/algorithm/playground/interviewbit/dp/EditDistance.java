package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class EditDistance {

    public int minDistance(String a, String b) {
        int[][] table = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0) {
                    table[i][j] = j;
                } else if (j == 0) {
                    table[i][j] = i;
                } else if (a.charAt(i-1) == b.charAt(j-1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + Math.min(
                            Math.min(
                                    table[i - 1][j - 1],
                                    table[i][j - 1]
                            ),
                            table[i - 1][j]
                    );
                }
            }
        }
        return table[a.length()][b.length()];
    }
}
