package com.daniel.goncharov.algorithm.playground.leetcode.dp

class JumpGame2 {

    fun canJump(nums: IntArray): Boolean {
        val cache = MutableList(
            nums.size
        ) { index ->
            if (index == 0) {
                true
            } else {
                null
            }
        }
        return canJump(0, nums, cache)
    }

    private fun canJump(
        start: Int,
        nums: IntArray,
        steps: MutableList<Boolean?>
    ): Boolean {
        steps[start]?.let { canJump -> return canJump }
        if (start >= nums.size - 1) return true
        if (nums[start] == 0) return false
        var result = false
        for (index in start + 1 until nums[start] + start + 1) {
            result = result or canJump(index, nums, steps)
        }
        steps[start] = result
        return result
    }

}