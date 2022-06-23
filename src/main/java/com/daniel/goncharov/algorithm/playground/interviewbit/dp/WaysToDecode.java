package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.HashMap;

public class WaysToDecode {

    public int numDecodings(String encodedString) {
        if (encodedString.length() == 0) return 0;
        return countDecodings(encodedString, 0, 1, new HashMap<>());
    }

    private int countDecodings(
            String encodedString,
            int left,
            int right,
            HashMap<String, Integer> cache
    ) {

        int value = Integer.valueOf(encodedString.substring(left, right));
        if (value >= 27 || value==0) return 0;
        if (right == encodedString.length()) return 1;
        String key = new StringBuilder().append(left).append(right).toString();
        if (cache.containsKey(key)) {
            return cache.get(key);
        }


        int contiguesResult = countDecodings(encodedString, left, right + 1, cache);
        key = new StringBuilder().append(left).append(right + 1).toString();
        cache.put(key, contiguesResult);

        int nextIsSeparateResult = countDecodings(encodedString, right, right + 1, cache);
        key = new StringBuilder().append(right).append(right + 1).toString();
        cache.put(key, nextIsSeparateResult);

        return (contiguesResult + nextIsSeparateResult)%1000000007;

    }
}
