package com.daniel.goncharov.algorithm.playground.leetcode.dp

import java.lang.Integer.max


class PartitionArrayForMaximumSum {

    fun maxSumAfterPartitioning(array: IntArray, window: Int): Int {
        val maxes: MutableList<MutableList<Int>> = MutableList(array.size) { i ->
            MutableList(array.size) { j ->
                if (i == j) {
                    array[i]
                } else {
                    0
                }
            }
        }
        for (i in maxes.indices) {
            for (j in i + 1 until maxes.first().size) {
                maxes[i][j] = max(maxes[i][j - 1], maxes[i + 1][j])
            }
        }
        return solveRecursive(0, maxes, window)
    }

    private fun solveRecursive(
        index: Int,
        maxes: List<List<Int>>,
        window: Int
    ): Int {
        var max = Int.MIN_VALUE
        val until = if (index + window > maxes.size) maxes.size else index + window
        for (i in index until until) {
            max = max(max, maxes[index][i] + solveRecursive(i, maxes, window))
        }
        return max
    }
}