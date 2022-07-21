package com.daniel.goncharov.algorithm.playground.leetcode.dp

class UniquePaths {

    fun uniquePaths(rows: Int, columns: Int): Int {
        val steps = MutableList(rows + 1) { MutableList(columns + 1) { 0 } }
        for (i in 1 until rows + 1) {
            for (j in 1 until columns + 1) {
                if (i == 1 && j == 1) {
                    steps[i][j] = 1
                } else {
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1]
                }
            }
        }
        return steps[rows][columns]
    }
}