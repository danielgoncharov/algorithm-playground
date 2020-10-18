package com.daniel.goncharov.algorithm.playground.dp;

public class WaysToDecode {

    private int numDecodings = 0;

    public int numDecodings(String encodedString) {
        if (encodedString.length() == 0) return 0;
        return countDecodings(encodedString, 0, 1);
    }

    private int countDecodings(
            String encodedString,
            int left,
            int right
    ) {
        int value = Integer.valueOf(encodedString.substring(left, right));
        if (value < 27) return 0;
        if (right == encodedString.length()) return 1;


        return countDecodings(encodedString, left, right + 1) +
                countDecodings(encodedString, right, right + 1);

    }

}
