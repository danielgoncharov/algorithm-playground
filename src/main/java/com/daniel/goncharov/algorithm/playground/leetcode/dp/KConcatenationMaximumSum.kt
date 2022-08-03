package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class KConcatenationMaximumSum {

//    breaks when [-5,-2,0,0,3,9,-2,-5,4]
//    5

    fun kConcatenationMaxSum(arr: IntArray, repeatTime: Int): Int {
        if (arr.isEmpty()) return 0
        val maxSubArray = maxSubArray(arr)
        if (repeatTime == 1) return maxSubArray

        val maxPrefix = maxPrefix(arr)
        arr.reverse()
        val maxSufix = maxPrefix(arr)

        val wholeArray = arr.sum()

        return arrayListOf(
            maxPrefix + maxSufix,
            wholeArray * repeatTime,
            maxSubArray,
            0,
            wholeArray * (repeatTime - 2) + maxPrefix + maxSufix
        ).maxOrNull() ?: 0
    }

    fun maxPrefix(nums: IntArray): Int {
        var localMax = nums.first()
        var sum = nums.first()
        for (index in 1 until nums.size) {
            val number = nums[index]
            sum += number
            localMax = max(sum, localMax)
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


