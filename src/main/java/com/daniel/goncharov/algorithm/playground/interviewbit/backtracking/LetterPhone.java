package com.daniel.goncharov.algorithm.playground.interviewbit.backtracking;

import java.util.ArrayList;

public class LetterPhone {

    private final String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        combine(result, digits, 0, "");
        return result;
    }

    private void combine(
            ArrayList<String> result,
            final String digits,
            int currentIndex,
            String string
    ) {
        if (currentIndex == digits.length()) {
            result.add(string);
            return;
        }
        String letters = mapping[Character.getNumericValue(digits.charAt(currentIndex))];
        for (int index = 0; index < letters.length(); index++) {
            combine(result, digits, currentIndex + 1, string + letters.charAt(index));
        }
    }
}
