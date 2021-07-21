package com.daniel.goncharov.algorithm.playground.two.pointers

import com.daniel.goncharov.algorithm.playground.pointers.Diffk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DiffkTest {

    @Test
    fun trivialTest() {
        val expected = Diffk().diffPossible(arrayListOf(1, 2, 2, 3, 4), 0)
        assertThat(expected).isEqualTo(1)
    }
}