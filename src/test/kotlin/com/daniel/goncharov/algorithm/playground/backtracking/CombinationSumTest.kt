package com.daniel.goncharov.algorithm.playground.backtracking

import org.junit.Test

class CombinationSumTest {

    @Test
    fun shouldFindGeneric() {
        val list = arrayListOf(15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 )

        val result = CombinationSum2().combinationSum(list, 33)
    }

}