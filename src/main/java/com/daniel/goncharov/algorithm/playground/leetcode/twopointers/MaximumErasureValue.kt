package com.daniel.goncharov.algorithm.playground.leetcode.twopointers

import kotlin.math.max

class MaximumErasureValue {

    fun maximumUniqueSubarray(nums: IntArray): Int {
        val set = HashSet<Int>()
        var maxSum = Int.MIN_VALUE
        var currentSum = 0
        var left = 0
        for (right in nums.indices) {
            var currentElement = nums[right]
            currentSum += nums[right]
            if (set.contains(currentElement)) {
                while (nums[left] != nums[right]) {
                    currentSum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                if (nums[left] == nums[right]) {
                    currentSum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
            set.add(currentElement)
            maxSum = max(maxSum, currentSum)
        }
        return maxSum
    }
}