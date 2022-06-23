package com.daniel.goncharov.algorithm.playground.interviewbit.backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String inputString) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        findPartitions(result, inputString, new ArrayList<>(), 0, inputString.length());
        return result;
    }

    private void findPartitions(
            ArrayList<ArrayList<String>> result,
            String inputString,
            ArrayList<String> partition,
            int startIndex,
            int limit
    ) {
        if (startIndex == limit) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int index = startIndex; index < inputString.length(); index++) {
            String currentString = inputString.substring(startIndex, index + 1);
            if (!isPalindrome(currentString)) continue;
            partition.add(currentString);
            findPartitions(result, inputString, partition, index+1, limit);
            partition.remove(partition.size() - 1);
        }
    }

    private boolean isPalindrome(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
