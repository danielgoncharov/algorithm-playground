package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class UncrossedLines {

    // are there any duplicates?

    fun maxUncrossedLines(arrayA: IntArray, arrayB: IntArray): Int {
        val cache: MutableList<MutableList<Int?>> = MutableList(arrayA.size) {
            MutableList<Int?>(arrayB.size) {
                null
            }
        }
        return findMaxLines(
            arrayA,
            0,
            arrayB,
            0,
            cache
        )
    }

    private fun findMaxLines(
        arrayA: IntArray,
        aIndex: Int,
        arrayB: IntArray,
        bIndex: Int,
        cache: MutableList<MutableList<Int?>>
    ): Int {
        if (aIndex == arrayA.size || bIndex == arrayB.size) return 0
        cache[aIndex][bIndex]?.let { return it }
        if (arrayA[aIndex] == arrayB[bIndex]) {
            cache[aIndex][bIndex] = 1 + findMaxLines(arrayA, aIndex + 1, arrayB, bIndex + 1, cache)
        } else {
            cache[aIndex][bIndex] = max(
                findMaxLines(arrayA, aIndex + 1, arrayB, bIndex, cache),
                findMaxLines(arrayA, aIndex, arrayB, bIndex + 1, cache)
            )
        }
        return cache[aIndex][bIndex] ?: 0
    }

}