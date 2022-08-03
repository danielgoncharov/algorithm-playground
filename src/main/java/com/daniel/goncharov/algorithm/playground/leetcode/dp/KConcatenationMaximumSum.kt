package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class KConcatenationMaximumSum {

    fun kConcatenationMaxSum(arr: IntArray, repeatTime: Int): Int {
        if (arr.isEmpty()) return 0
        val maxSubArray = maxSubArray(arr)
        if (repeatTime == 1) return maxSubArray

        val maxPrefix = maxPrefix(arr)
        arr.reverse()
        val maxSufix = maxPrefix(arr)

        val wholeArraySum = arr.sum() % 1000000007

        return if (wholeArraySum >= 0) {
            max(
                mult(wholeArraySum, repeatTime - 2) + maxPrefix + maxSufix,
                maxSubArray
            )
        } else {
            max(
                (maxPrefix + maxSufix),
                maxSubArray
            )
        } % 1000000007
    }

    fun mult(init: Int, time: Int): Int {
        var sum = 0
        repeat(time) {
            sum = (sum + init) % 1000000007
        }
        return sum
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
        return if (max < 0) 0 else max
    }
}


