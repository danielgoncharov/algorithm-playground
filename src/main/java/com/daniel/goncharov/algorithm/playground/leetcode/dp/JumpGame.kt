package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.min

class JumpGame {

    fun jump(nums: IntArray): Int {
        val steps = MutableList(
            nums.size
        ) { index ->
            if (index == 0) {
                0
            } else {
                Int.MAX_VALUE
            }
        }

        steps[0] = 0
        for (index in nums.indices) {
            val untilIndex = nums[index] + index + 1
            for (i in index + 1 until untilIndex) {
                if (i == nums.size) break
                steps[i] = min(steps[i], steps[index] + 1)
            }
        }
        return steps.last()
    }


}