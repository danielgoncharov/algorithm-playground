package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class RegularExpressionMatch {

    public int isMatch(final String string, final String pattern) {
        boolean[][] table = new boolean[pattern.length() + 1][string.length() + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == j && i == 0) {
                    table[i][j] = true;
                } else if (i == 0) {
                    table[i][j] = false;
                } else if (j == 0) {
                    table[i][j] = pattern.charAt(i - 1) == '*' && table[i - 1][j];
                } else if (pattern.charAt(i - 1) == string.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    table[i][j] = table[i][j - 1] || table[i - 1][j];
                } else {
                    table[i][j] = false;
                }
            }
        }
        return table[pattern.length()][string.length()] ? 1 : 0;
    }
}
