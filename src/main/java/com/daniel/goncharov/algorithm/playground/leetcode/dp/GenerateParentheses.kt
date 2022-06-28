package com.daniel.goncharov.algorithm.playground.leetcode.dp

class GenerateParentheses {

    fun generateParenthesis(pairsCount: Int): List<String> {
        val result = arrayListOf<String>()
        generateRec(1, 0, result, pairsCount, "(")
        return result
    }

    private tailrec fun generateRec(
        openCount: Int,
        closeCount: Int,
        result: MutableList<String>,
        pairsCount: Int,
        currentString: String
    ) {
        if (closeCount == pairsCount) {
            result.add(currentString)
        } else if (openCount == closeCount) {
            generateRec(openCount + 1, closeCount, result, pairsCount, "$currentString(")
        } else if (openCount == pairsCount) {
            generateRec(openCount, closeCount + 1, result, pairsCount, "$currentString)")
        } else {
            generateRec(openCount + 1, closeCount, result, pairsCount, "$currentString(")
            generateRec(openCount, closeCount + 1, result, pairsCount, "$currentString)")
        }
    }
}