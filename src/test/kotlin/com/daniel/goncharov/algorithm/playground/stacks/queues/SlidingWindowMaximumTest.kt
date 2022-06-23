package com.daniel.goncharov.algorithm.playground.stacks.queues

import com.daniel.goncharov.algorithm.playground.interviewbit.queues.SlidingWindowMaximum
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SlidingWindowMaximumTest {

    private val slidingWindowMaximum =
        SlidingWindowMaximum()

    @Test
    fun shouldCalculateTrivial1() {
        val list = arrayListOf(1, 3, -1, -3, 5, 3, 6, 7)
        val result = slidingWindowMaximum.slidingMaximum(list, 3)
        assertThat(result).isEqualTo(arrayListOf(3, 3, 5, 5, 6, 7))
    }

    @Test
    fun shouldCalculateTrivial2() {
        val list = arrayListOf(1, 3, -2, -1, -3, 5, 3, 6, 7)
        val result = slidingWindowMaximum.slidingMaximum(list, 3)
        assertThat(result).isEqualTo(arrayListOf(3, 3, -1, 5, 5, 6, 7))
    }

    @Test
    fun shouldCalculateTrivial3() {
        val list = arrayListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        val result = slidingWindowMaximum.slidingMaximum(list, 2)
        assertThat(result).isEqualTo(arrayListOf(10,9,8,7,6,5,4,3,2 ))
    }

    @Test
    fun shouldCalculateTrivial4() {
        val list = arrayListOf(90, 140, 440, 630, 885, 838, 176, 756, 536, 430, 645, 367, 943, 150, 214, 619, 616, 82, 19, 994, 431, 440, 399, 273, 166, 170, 596, 586, 350, 497, 401, 56, 486, 472, 661, 269, 136, 51, 222, 4, 877, 722, 877, 76, 318, 643, 946, 836, 17, 315, 404, 86, 687, 313, 447, 1, 337, 782, 32, 376, 327, 540, 51, 428, 619, 526, 530, 935, 631, 444, 92, 473, 3, 855, 405, 396, 591, 926, 576, 138, 98)
        val result = slidingWindowMaximum.slidingMaximum(list, 5)
        assertThat(result).isEqualTo(arrayListOf(885,
                885,
                885,
                885,
                885,
                838,
                756,
                756,
                943,
                943,
                943,
                943,
                943,
                619,
                619,
                994,
                994,
                994,
                994,
                994,
                440,
                440,
                596,
                596,
                596,
                596,
                596,
                586,
                497,
                497,
                661,
                661,
                661,
                661,
                661,
                269,
                877,
                877,
                877,
                877,
                877,
                877,
                946,
                946,
                946,
                946,
                946,
                836,
                687,
                687,
                687,
                687,
                687,
                782,
                782,
                782,
                782,
                782,
                540,
                540,
                619,
                619,
                619,
                935,
                935,
                935,
                935,
                935,
                631,
                855,
                855,
                855,
                855,
                926,
                926,
                926,
                926 ))
    }
}