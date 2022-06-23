package com.daniel.goncharov.algorithm.playground.two.pointers

import com.daniel.goncharov.algorithm.playground.interviewbit.pointers.Sum3
import org.assertj.core.api.Assertions
import org.junit.Test

class Sum3Test {

    @Test
    fun trivialTest1() {
        val input = arrayListOf(-4, -8, -10, -9, -1, 1, -2, 0, -8, -2)
        val result = Sum3()
            .threeSumClosest(input, 0)
        Assertions.assertThat(result).isEqualTo(0)
    }

}