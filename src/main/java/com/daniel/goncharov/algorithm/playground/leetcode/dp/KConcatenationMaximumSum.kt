package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class KConcatenationMaximumSum {

//    breaks when [-5,-2,0,0,3,9,-2,-5,4]
//    5

    fun kConcatenationMaxSum(arr: IntArray, repeatTime: Int): Int {
        if (arr.isEmpty()) return 0
        val maxPrefix = maxPrefix(arr)
        val wholeArray = arr.sum()
        val maxSubArray = maxSubArray(arr)
        arr.reverse()
        val maxSufix = maxPrefix(arr)

        return arrayListOf(
            maxPrefix + maxSufix,
            wholeArray * repeatTime,
            maxSubArray,
            0
        ).maxOrNull() ?: 0
    }

    fun maxPrefix(nums: IntArray): Int {
        var localMax = nums.first()
        for (index in 1 until nums.size) {
            val number = nums[index]
            if (number >= localMax + number) {
                return localMax
            }
        }
        return localMax
    }

    fun maxSubArray(nums: IntArray): Int {
        var max = nums.first()
        var localMax = nums.first()
        for (index in 1 until nums.size) {
            val number = nums[index]
            localMax = max(number, localMax + number)
            if (localMax > max) {
                max = localMax
            }
        }
        return max
    }
}


