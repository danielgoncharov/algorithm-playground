package com.daniel.goncharov.algorithm.playground.dp;

public class RegularExpression2 {

    public int isMatch(final String string, final String pattern) {
        return isMatchRec(string, pattern) ? 1 : 0;
    }

    private boolean isMatchRec(final String string, final String pattern) {
        if (string.isEmpty() && pattern.isEmpty()) return true;
        if (string.isEmpty() && pattern.length() == 2 && pattern.charAt(1) == '*') return true;
        if (!string.isEmpty() && pattern.isEmpty()) return false;

        if (string.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') {
            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return isMatchRec(string.substring(1), pattern);
            } else {
                return isMatchRec(string.substring(1), pattern.substring(1));
            }
        } else if (pattern.length() > 2 && pattern.charAt(1) == '*') {
            return isMatchRec(string, pattern.substring(2));
        } else {
            return false;
        }
    }
}
