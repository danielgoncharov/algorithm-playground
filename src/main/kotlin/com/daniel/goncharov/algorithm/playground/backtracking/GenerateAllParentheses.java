package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;

public class GenerateAllParentheses {

    public ArrayList<String> generateParenthesis(int pairsOfParentheses) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(0, 0, pairsOfParentheses, result, new StringBuilder());
        return result;
    }

    private void backtrack(
            int openCount,
            int closeCount,
            int limit,
            ArrayList<String> result,
            StringBuilder tempResult) {
        if (openCount == limit && closeCount == limit) {
            result.add(tempResult.toString());
            return;
        }
        if (openCount < limit) {
            backtrack(openCount + 1, closeCount, limit, result, tempResult.append("("));
            tempResult.deleteCharAt(tempResult.length() - 1);
        }
        if (closeCount < limit && closeCount < openCount) {
            backtrack(openCount, closeCount + 1, limit, result, tempResult.append(")"));
            tempResult.deleteCharAt(tempResult.length() - 1);
        }
    }
}
