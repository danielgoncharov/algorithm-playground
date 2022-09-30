package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class UncrossedLines {

    // are there any duplicates?
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (i in nums2.indices) {
            map[nums2[i]] = i
        }
        return findMax(
            Interval(0, nums1.size - 1, 0),
            Interval(0, nums2.size - 1, 0),
            nums1,
            map
        )
    }

    private fun findMax(
        num1AllowedInterval: Interval,
        num2AllowedInterval: Interval,
        nums1: IntArray,
        indexMap: Map<Int, Int>
    ): Int {
        if (!num1AllowedInterval.isValidInterval() || !num2AllowedInterval.isValidInterval()) return 0
        val valInNum1 = nums1[num1AllowedInterval.index]
        val indexInNum2 = indexMap[valInNum1]
            ?: return findMax(
                num1AllowedInterval.dontDrawLine(),
                num2AllowedInterval,
                nums1,
                indexMap
            )
        val num2AllowedIntervalWithIndex = num2AllowedInterval.copy(index = indexInNum2)
        return max(
            findMax(
                num1AllowedInterval.dontDrawLine(),
                num2AllowedInterval,
                nums1,
                indexMap
            ),
            findMax(
                num1AllowedInterval.drawLineLeftInterval(),
                num2AllowedIntervalWithIndex.drawLineLeftInterval(),
                nums1,
                indexMap
            ) +
                    findMax(
                        num1AllowedInterval.drawLineRightInterval(),
                        num2AllowedIntervalWithIndex.drawLineRightInterval(),
                        nums1,
                        indexMap
                    ) +
                    1
        )
    }


    data class Interval(
        val left: Int,
        val right: Int,
        val index: Int
    ) {
        fun isValidInterval(): Boolean = left <= right && index >= left && index <= right

        fun dontDrawLine(): Interval {
            return copy(index = index + 1)
        }

        fun drawLineLeftInterval(): Interval {
            return copy(right = index - 1)
        }

        fun drawLineRightInterval(): Interval {
            return copy(left = index + 1)
        }
    }

}