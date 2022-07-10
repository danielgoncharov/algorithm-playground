package com.daniel.goncharov.algorithm.playground.leetcode.dp

class JumpGame2 {


    fun canJump(nums: IntArray): Boolean {
        val cache = MutableList(
            nums.size
        ) { index -> index == 0 }

        cache[0] = true
        for (index in nums.indices) {
            val untilIndex = nums[index] + index + 1
            for (i in index + 1 until untilIndex) {
                if (i == nums.size) break
                cache[i] = cache[index]
            }
        }
        return cache.last()
    }

}