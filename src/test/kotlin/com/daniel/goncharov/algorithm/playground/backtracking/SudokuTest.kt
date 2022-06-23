package com.daniel.goncharov.algorithm.playground.backtracking

import com.daniel.goncharov.algorithm.playground.interviewbit.backtracking.Sudoku
import org.junit.Test

class SudokuTest {
    @Test
    fun shouldFindGeneric1() {
        val input = arrayListOf(
                arrayListOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                arrayListOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                arrayListOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                arrayListOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                arrayListOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                arrayListOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                arrayListOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                arrayListOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                arrayListOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        var list=ArrayList(input)
        val result = Sudoku().solveSudoku(list)
    }
}