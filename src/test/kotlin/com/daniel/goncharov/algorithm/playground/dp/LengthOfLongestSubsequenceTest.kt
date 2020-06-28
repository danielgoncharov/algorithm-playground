package com.daniel.goncharov.algorithm.playground.dp

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LengthOfLongestSubsequenceTest {

    @Test
    fun test1() {
        val result = LengthOfLongestSubsequence().longestSubsequenceLength(arrayListOf(1, 3, 5, 6, 4, 8, 4, 3, 2, 1))
        assertThat(result).isEqualTo(9)
    }

    @Test
    fun test2() {
        val result = LengthOfLongestSubsequence().longestSubsequenceLength(arrayListOf(12, 11, 40, 5, 3, 1))
        assertThat(result).isEqualTo(5)
    }
}