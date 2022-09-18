package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class LongestPalindromicSubsequence {

    fun longestPalindromeSubseq(seq: String): Int {
        return find(seq, 0, seq.length - 1)
    }

    fun find(seq: String, left: Int, right: Int): Int {
        if (left == right) return 1
        if (seq[left] == seq[right] && left + 1 == right) return 2
        if (seq[left] == seq[right]) {
            return find(
                seq,
                left + 1,
                right - 1
            ) + 2
        }
        return max(
            find(seq, left, right - 1),
            find(seq, left + 1, right)
        )

    }
}