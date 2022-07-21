package com.daniel.goncharov.algorithm.playground.leetcode.dp

class UniquePaths {

    fun uniquePaths(rows: Int, columns: Int): Int {
        return countPaths(0, 0, rows, columns)
    }

    private fun countPaths(
        currentRowIndex: Int,
        currentColumnIndex: Int,
        rows: Int,
        columns: Int
    ): Int {
        if (currentRowIndex == rows || currentColumnIndex == columns) return 0
        if (currentRowIndex == rows - 1 && currentColumnIndex == columns - 1) return 1
        return countPaths(
            currentRowIndex + 1,//go down
            currentColumnIndex,
            rows,
            columns
        ) + countPaths(//
            currentRowIndex,
            currentColumnIndex + 1,//go right
            rows,
            columns
        )
    }
}