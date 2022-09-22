package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class LongestPalindromicSubsequence {

    fun longestPalindromeSubseq(seq: String): Int {
        val cache = MutableList(seq.length) { row ->
            MutableList(seq.length) { column ->
                if (row == column) 1
                else 0
            }
        }
        for (startColumn in 1 until seq.length) {
            for (row in 0 until seq.length - startColumn) {
                val column = startColumn + row
                val left = seq[row]
                val right = seq[column]
                when {
                    startColumn == 1 && left == right -> cache[row][column] = 2
                    left == right -> cache[row][column] = 2 + cache[row + 1][column - 1]
                    else -> {
                        cache[row][column] = max(
                            cache[row][column - 1],
                            cache[row + 1][column]
                        )
                    }
                }

            }
        }
        return cache[0][seq.length - 1]
    }

}