package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class UncrossedLines {

    // are there any duplicates?

    fun maxUncrossedLines(arrayA: IntArray, arrayB: IntArray): Int {
        return findMaxLines(arrayA, 0, arrayB, 0)
    }

    private fun findMaxLines(
        arrayA: IntArray,
        aIndex: Int,
        arrayB: IntArray,
        bIndex: Int
    ): Int {
        if (aIndex == arrayA.size || bIndex == arrayB.size) return 0
        return if (arrayA[aIndex] == arrayB[bIndex]) {
            1 + findMaxLines(arrayA, aIndex + 1, arrayB, bIndex + 1)
        } else {
            max(
                findMaxLines(arrayA, aIndex + 1, arrayB, bIndex),
                findMaxLines(arrayA, aIndex, arrayB, bIndex + 1)
            )
        }
    }

}