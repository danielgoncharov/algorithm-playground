package com.daniel.goncharov.algorithm.playground.leetcode.dp

class LongestIncreasingSubsequence {

    private val TOP_LAYER = -1

    fun lengthOfLIS(nums: IntArray): Int {
        return findLongest(TOP_LAYER, nums)
    }

    private fun findLongest(
        lastPickedIndex: Int,
        nums: IntArray
    ): Int {
        var maxLength = 0
        for (nextPickIndex in lastPickedIndex + 1 until nums.size) {
            if (lastPickedIndex == TOP_LAYER || nums[nextPickIndex] > nums[lastPickedIndex]) {
                maxLength = maxOf(maxLength, findLongest(nextPickIndex, nums) + 1)
            }
        }
        return maxLength
    }
}