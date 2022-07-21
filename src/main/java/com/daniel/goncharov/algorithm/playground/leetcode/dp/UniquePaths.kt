package com.daniel.goncharov.algorithm.playground.leetcode.dp

class UniquePaths {

    fun uniquePaths(rows: Int, columns: Int): Int {
        val steps = MutableList(rows) { MutableList(columns) { -1 } }
        return countPaths(0, 0, rows, columns, steps)
    }

    private fun countPaths(
        currentRowIndex: Int,
        currentColumnIndex: Int,
        rows: Int,
        columns: Int,
        steps: MutableList<MutableList<Int>>
    ): Int {
        if (currentRowIndex == rows || currentColumnIndex == columns) return 0
        if (currentRowIndex == rows - 1 && currentColumnIndex == columns - 1) return 1
        if (steps[currentRowIndex][currentColumnIndex] != -1) return steps[currentRowIndex][currentColumnIndex]
        steps[currentRowIndex][currentColumnIndex] = countPaths(
            currentRowIndex + 1,//go down
            currentColumnIndex,
            rows,
            columns,
            steps,
        ) + countPaths(//
            currentRowIndex,
            currentColumnIndex + 1,//go right
            rows,
            columns,
            steps
        )
        return steps[currentRowIndex][currentColumnIndex]
    }
}