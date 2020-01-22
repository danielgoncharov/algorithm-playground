package com.daniel.goncharov.algorithm.playground.backtracking

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PalindromePartitioningTest {

    @Test
    fun shouldFindGeneric1() {
        val result = PalindromePartitioning().partition("aab")
        assertThat(result).isEqualTo(arrayListOf(arrayListOf("a", "a", "b"), arrayListOf("aa", "b")))
    }
}