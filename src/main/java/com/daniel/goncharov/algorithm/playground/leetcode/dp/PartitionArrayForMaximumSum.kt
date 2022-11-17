package com.daniel.goncharov.algorithm.playground.leetcode.dp

import java.lang.Integer.max


class PartitionArrayForMaximumSum {
    fun maxSumAfterPartitioning(array: IntArray, windowSize: Int): Int {
        val cache = initCache(array, windowSize)
        val maxes = initMaxes(array)

        for (currentWindow in 0 until windowSize) {
            for (index in array.indices) {
                if (index < currentWindow + 1) {
                    cache[currentWindow][index] = maxes[index][index + currentWindow + 1] * (currentWindow + 1)
                } else {
                    var max = Int.MIN_VALUE
                    for (left in index downTo index - currentWindow) {
                        max = max(max, cache[currentWindow][left] + maxes[left][index])
                    }
                    cache[currentWindow][index] = max
                }
            }
        }

        return cache[windowSize - 1][array.size - 1]
    }

    private fun initCache(array: IntArray, windowSize: Int): MutableList<MutableList<Int>> {
        return MutableList(windowSize) { i ->
            MutableList(array.size) { j ->
                if (i == 0) {
                    array[j]
                } else if (j == 0) {
                    array[j]
                } else {
                    0
                }
            }
        }
    }

    private fun initMaxes(array: IntArray): MutableList<MutableList<Int>> {
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
        return maxes
    }
}