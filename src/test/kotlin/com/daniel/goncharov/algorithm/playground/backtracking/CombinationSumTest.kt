package com.daniel.goncharov.algorithm.playground.backtracking

import org.junit.Test

class CombinationSumTest {

    @Test
    fun shouldFindGeneric() {
        val list = arrayListOf(6, 6, 3, 3, 6, 5)

        val result = Subsets2().subsetsWithDup(list)
    }

}