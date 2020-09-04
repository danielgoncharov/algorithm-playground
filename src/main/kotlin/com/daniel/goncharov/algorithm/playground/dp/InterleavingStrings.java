package com.daniel.goncharov.algorithm.playground.dp;

public class InterleavingStrings {

    public int isInterleave(String A, String B, String C) {
        if (A.length() + B.length() != C.length()) return 0;
        boolean[][] table = new boolean[A.length() + 1][B.length() + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = true;
                } else if (i == 0) {
                    table[i][j] = B.charAt(j - 1) == C.charAt(j - 1);
                } else if (j == 0) {
                    table[i][j] = A.charAt(i - 1) == C.charAt(i - 1);
                } else if (A.charAt(i - 1) == C.charAt(i + j - 1)) {
                    table[i][j] = table[i - 1][j];
                } else if (B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    table[i][j] = table[i][j - 1];
                } else {
                    table[i][j] = false;
                }
            }
        }
        return table[A.length()][B.length()] ? 1 : 0;
    }


}
