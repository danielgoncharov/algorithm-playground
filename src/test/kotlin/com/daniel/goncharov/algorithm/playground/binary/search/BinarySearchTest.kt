package com.daniel.goncharov.algorithm.playground.binary.search


import com.daniel.goncharov.algorithm.playground.search.BinarySearch
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class BinarySearchTest {

    @Test fun shouldFindGeneric() {
        val sortedList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val expectedPosition = BinarySearch().find(sortedList, 8)
        assertThat(expectedPosition).isEqualTo(8)
    }

    @Test fun shouldFindViaTwo() {
        val sortedList = listOf(0, 1)
        val expectedPosition = BinarySearch().find(sortedList, 1)
        assertThat(expectedPosition).isEqualTo(1)
    }

}