package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.min
import kotlin.math.sqrt

class PerfectSquares {

    fun numSquares(n: Int): Int {

    }

    private fun leastNumSquares(number: Int): Int {
        if (number == 0) return 0

        val root = sqrt(number.toFloat())
            .toString()
            .split(".")
        val rootInt = root.first().toInt()
        val rootDec = root.last().toInt()

        if (rootDec == 0) return 1

        var min = Int.MAX_VALUE
        for (root in rootInt downTo 1) {
            var remainingNumber = number - root * root
            min = min(min, leastNumSquares(remainingNumber))
        }
        return min + 1
    }
}