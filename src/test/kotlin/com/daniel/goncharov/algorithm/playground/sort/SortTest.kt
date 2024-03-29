package com.daniel.goncharov.algorithm.playground.sort

import com.daniel.goncharov.algorithm.playground.interviewbit.sort.QuickSort
import com.daniel.goncharov.algorithm.playground.interviewbit.sort.Sort
import org.junit.Before
import org.junit.Test


class SortTest {

    private lateinit var sortMethod: Sort

    @Before
    fun setUp() {
        sortMethod = QuickSort()
    }

    @Test
    fun shouldSortEven() {
        val sort = intArrayOf(9, 1, 5, 7, 2, 0, 3, 4)
        val output = sortMethod.sort(sort)
        println(output.asList())
    }

    @Test
    fun shouldSortOdd() {
        val sort = intArrayOf(9, 1, 5, 7, 2, 0, 3)
        val output = sortMethod.sort(sort)
        println(output.asList())
    }

    @Test
    fun shouldOne() {
        val sort = intArrayOf(9)
        val output = sortMethod.sort(sort)
        println(output.asList())
    }

    @Test
    fun shouldTwo() {
        val sort = intArrayOf(1, 2)
        val output = sortMethod.sort(sort)
        println(output.asList())
    }

    @Test
    fun shouldThree() {
        val sort = intArrayOf(7, 1, 2)
        val output = sortMethod.sort(sort)
        println(output.asList())
    }
}