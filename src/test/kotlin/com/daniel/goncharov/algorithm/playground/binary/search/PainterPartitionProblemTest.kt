package com.daniel.goncharov.algorithm.playground.binary.search


class PainterPartitionProblemTest {


    @Test
    fun shouldSolveGenericProblem() {
        val board = arrayListOf(100, 200, 300, 400, 500, 600, 700, 800, 900)
        val expectedPosition = PainterPartitionProblem().paint(3, 1, board)
    }
}