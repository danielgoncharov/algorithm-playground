package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max


class MaximumSubarray {

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