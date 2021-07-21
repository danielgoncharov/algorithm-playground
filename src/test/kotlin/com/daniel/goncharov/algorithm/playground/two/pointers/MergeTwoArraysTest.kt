package com.daniel.goncharov.algorithm.playground.two.pointers

import com.daniel.goncharov.algorithm.playground.pointers.MergeTwoArrays
import org.assertj.core.api.Assertions
import org.junit.Test

class MergeTwoArraysTest {

    @Test
    fun trivialMergeTest() {
        val left = arrayListOf(1, 5, 8)
        val right = arrayListOf(6, 9)
        MergeTwoArrays().merge(left, right)
        val expectedArray = arrayListOf(1, 5, 6, 8, 9)

        Assertions.assertThat(left).isEqualTo(expectedArray)
    }
}