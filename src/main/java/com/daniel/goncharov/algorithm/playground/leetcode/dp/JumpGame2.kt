package com.daniel.goncharov.algorithm.playground.leetcode.dp

class JumpGame2 {

    fun canJump(nums: IntArray): Boolean {
        return canJump(0, nums)
    }

    private fun canJump(start: Int, nums: IntArray): Boolean {
        if (start >= nums.size - 1) return true
        if (nums[start] == 0) return false
        var result = false
        for (index in start + 1 until nums[start] + start + 1) {
            result = result or canJump(index, nums)
        }
        return result
    }

}