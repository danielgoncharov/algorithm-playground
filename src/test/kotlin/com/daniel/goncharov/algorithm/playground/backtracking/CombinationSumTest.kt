package com.daniel.goncharov.algorithm.playground.backtracking

import org.junit.Test

class CombinationSumTest {

    @Test
    fun shouldFindGeneric() {
        val list = arrayListOf(8, 10, 6, 11, 1, 16, 8)

        CombinationSum().combinationSum(list, 28)
    }

}