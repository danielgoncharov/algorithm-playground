package com.daniel.goncharov.algorithm.playground.dp;

public class PalindromicSubstrings {

    public int solve(String string) {
        int numberOfPalindromes = 0;
        for (int i = 0; i < string.length(); i++) {
            numberOfPalindromes += 1 + countPalindromes(string, i - 1, i + 1);
            int nextItemIndex = i + 1;
            if (nextItemIndex != string.length() && string.charAt(i) == string.charAt(nextItemIndex)) {
                numberOfPalindromes += 1 + countPalindromes(string, i - 1, i + 2);
            }
        }
        return numberOfPalindromes;
    }

    private int countPalindromes(
            String baseString,
            int leftIndex,
            int rightIndex) {
        if (leftIndex < 0 || rightIndex >= baseString.length()) return 0;
        if (baseString.charAt(leftIndex) != baseString.charAt(rightIndex)) return 0;
        return 1 + countPalindromes(baseString, leftIndex + 1, rightIndex + 1);
    }
}
