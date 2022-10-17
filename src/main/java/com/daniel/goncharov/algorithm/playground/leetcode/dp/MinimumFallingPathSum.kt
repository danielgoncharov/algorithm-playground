package com.daniel.goncharov.algorithm.playground.leetcode.dp

import java.lang.Integer.min

class MinimumFallingPathSum {

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val cache = MutableList(matrix.size) {
            arrayOfNulls<Int>(matrix.first().size)
        }

        var min = Int.MAX_VALUE
        for (i in 0 until matrix.first().size) {
            min = min(min, solveTop2Bottom(0, i, matrix, cache) ?: min)
        }

        return min

    }

    private fun solveTop2Bottom(
        row: Int,
        column: Int,
        matrix: Array<IntArray>,
        cache: MutableList<Array<Int?>>
    ): Int? {
        if (
            column < 0 ||
            column == matrix.first().size
        ) return null

        if (row == matrix.size - 1) {
            cache[row][column] = matrix[row][column]
            return cache[row][column]
        }

        cache[row][column]?.let { return it }

        val nextRowMin = arrayListOf(
            solveTop2Bottom(row + 1, column, matrix, cache),
            solveTop2Bottom(row + 1, column + 1, matrix, cache),
            solveTop2Bottom(row + 1, column - 1, matrix, cache)
        ).filterNotNull().minOrNull() ?: Int.MAX_VALUE
        cache[row][column] = matrix[row][column] + nextRowMin
        return cache[row][column]
    }
}