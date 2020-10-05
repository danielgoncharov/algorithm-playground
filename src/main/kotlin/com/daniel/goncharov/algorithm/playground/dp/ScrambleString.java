package com.daniel.goncharov.algorithm.playground.dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    public int isScramble(final String A, final String B) {
        if (A.length() != B.length()) return 0;
        HashMap<String, Boolean> cache = new HashMap<>();
        return isScrambleRec(A, B, cache) ? 1 : 0;
    }

    private boolean isScrambleRec(String s1, String s2, Map<String, Boolean> cache) {

        if (s1.equals(s2)) return true;
        if (s1.length() <= 1) return false;
        String cacheKey = s1 + " " + s2;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        boolean flag = false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScrambleRec(s1.substring(0, i), s2.substring(0, i), cache)
                    && isScrambleRec(s1.substring(i), s2.substring(i), cache)) {
                flag = true;
                break;
            }

            if (isScrambleRec(s1.substring(0, i), s2.substring(n - i, n), cache)
                    && isScrambleRec(s1.substring(i, n), s2.substring(0, n - i), cache)) {
                flag = true;
                break;
            }
        }

        cache.put(cacheKey, flag);
        return flag;
    }

}

