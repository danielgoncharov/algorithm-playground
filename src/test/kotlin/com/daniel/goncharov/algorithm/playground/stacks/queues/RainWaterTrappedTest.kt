package com.daniel.goncharov.algorithm.playground.stacks.queues

import com.daniel.goncharov.algorithm.playground.interviewbit.queues.RainWaterTrapped
import org.assertj.core.api.Assertions
import org.junit.Test

class RainWaterTrappedTest {

    private val rainWaterTrapped =
        RainWaterTrapped()

    @Test
    fun shouldCalculateTrivial() {
        val list = arrayListOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val result = rainWaterTrapped.trap(list)
        Assertions.assertThat(result).isEqualTo(6)
    }

}