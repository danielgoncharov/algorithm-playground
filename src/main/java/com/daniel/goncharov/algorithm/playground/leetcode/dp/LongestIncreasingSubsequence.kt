package com.daniel.goncharov.algorithm.playground.leetcode.dp

class LongestIncreasingSubsequence {

    //Goal nlogn. Some kind of a tree? priority queue? Heap

    fun lengthOfLIS(nums: IntArray): Int {
        val cache = MutableList(nums.size) { 1 }
        for (index in 1 until nums.size) {
            cache[index] = maxFrom(index, nums, cache) + 1
        }
        return cache.maxOrNull() ?: 0
    }

    //find max value of cache that is value of nums less than start
    private fun maxFrom(start: Int, array: IntArray, cache: MutableList<Int>): Int {
        var maxFrom = 0
        for (index in start - 1 downTo 0) {
            if (array[index] < array[start]) {
                maxFrom = maxOf(cache[index], maxFrom)
            }
        }
        return maxFrom
    }
}