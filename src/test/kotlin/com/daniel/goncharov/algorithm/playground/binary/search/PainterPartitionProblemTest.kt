package com.daniel.goncharov.algorithm.playground.binary.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class PainterPartitionProblemTest {


    @Test
    fun shouldSolveGenericProblem() {
        val board = arrayListOf(100, 200, 300, 400, 500, 600, 700, 800, 900)
        val expectedPosition = PainterPartitionProblem().paint(3, 1, board)
        assertThat(expectedPosition).isEqualTo(1700)
    }

    @Test
    fun shouldSolveTest1Problem() {
        val board = arrayListOf(1, 10)
        val expectedPosition = PainterPartitionProblem().paint(2, 5, board)
        assertThat(expectedPosition).isEqualTo(50)
    }

    @Test
    fun shouldSolveTest2Problem() {
        val board = arrayListOf(1000000, 1000000)
        val expectedPosition = PainterPartitionProblem().paint(1, 1000000, board)
        assertThat(expectedPosition).isEqualTo(9400003)
    }
}