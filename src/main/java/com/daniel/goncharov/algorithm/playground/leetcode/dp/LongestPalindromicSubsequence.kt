package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class LongestPalindromicSubsequence {

    fun longestPalindromeSubseq(seq: String): Int {
        val cache = MutableList(seq.length) {
            MutableList(seq.length) { 0 }
        }
        return find(seq, 0, seq.length - 1, cache)
    }

    fun find(
        seq: String,
        left: Int,
        right: Int,
        cache: MutableList<MutableList<Int>>
    ): Int {
        if (left == right) {
            cache[left][right] = 1
        } else if (seq[left] == seq[right] && left + 1 == right) {
            cache[left][right] = 2
        } else if (seq[left] == seq[right]) {
            cache[left][right] = find(
                seq,
                left + 1,
                right - 1,
                cache
            ) + 2
        } else {
            cache[left][right] = max(
                find(seq, left, right - 1, cache),
                find(seq, left + 1, right, cache)
            )
        }
        return cache[left][right]

    }
}