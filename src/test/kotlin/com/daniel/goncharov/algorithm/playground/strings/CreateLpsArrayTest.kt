package com.daniel.goncharov.algorithm.playground.strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class CreateLpsArrayTest {

    @Test fun lpsTest1() {
        val sortedList = intArrayOf(0, 0, 0, 0, 1, 2, 3, 1)
        val actualArray = CreateLpsArray().createLpsArray("abcdabca")
        assertThat(actualArray).isEqualTo(sortedList)
    }

    @Test fun lpsTest2() {
        val sortedList = intArrayOf(0, 1, 0, 1, 2, 3, 4, 5,2)
        val actualArray = CreateLpsArray().createLpsArray("aabaabaaa")
        assertThat(actualArray).isEqualTo(sortedList)
    }

}