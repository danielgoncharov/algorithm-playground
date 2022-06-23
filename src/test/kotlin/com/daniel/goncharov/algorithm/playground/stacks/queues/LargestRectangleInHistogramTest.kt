package com.daniel.goncharov.algorithm.playground.stacks.queues

import com.daniel.goncharov.algorithm.playground.interviewbit.queues.LargestRectangleInHistogram
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LargestRectangleInHistogramTest {

    private val largestRectangleInHistogram =
        LargestRectangleInHistogram()

    @Test
    fun shouldCalculateTrivial() {
        val list = arrayListOf(2, 1, 5, 6, 2, 3)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun shouldCalculateUniformWithOnes() {
        val list = arrayListOf(1, 1, 1, 1, 1, 1)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun shouldCalculateUniformWithFour() {
        val list = arrayListOf(4, 4, 4, 4, 4, 4)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(24)
    }

    @Test
    fun shouldCalculateTower() {
        val list = arrayListOf(4, 200, 4, 4, 4, 4)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(200)
    }

    @Test
    fun shouldCalculateTwoTowers() {
        val list = arrayListOf(6, 2, 2, 2, 2, 6)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun shouldCalculateAsc() {
        val list = arrayListOf(2, 3, 4, 5, 6, 7)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(16)
    }

    @Test
    fun shouldCalculateDesc() {
        val list = arrayListOf(7, 6, 5, 4, 3, 2)
        val result = largestRectangleInHistogram.largestRectangleArea(list)
        assertThat(result).isEqualTo(16)
    }
}