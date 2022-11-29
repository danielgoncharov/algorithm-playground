package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.min
import kotlin.math.sqrt

class PerfectSquares {

    fun numSquares(number: Int): Int {
        val mutableList = MutableList(number) { 0 }
        for (index in mutableList.indices) {
            var number = index + 1
            val root = sqrt(number.toFloat())
                .toString()
                .split(".")
            val rootInt = root.first().toInt()

            val rootDec = root.last().toInt()
            if (rootDec == 0) {
                mutableList[index] = 1
            } else {
                var min = Int.MAX_VALUE
                for (decrement in rootInt downTo 1) {
                    min = min(min, mutableList[number - decrement * decrement - 1])
                }
                mutableList[index] = 1 + min
            }
        }
        return mutableList[number - 1]
    }
}