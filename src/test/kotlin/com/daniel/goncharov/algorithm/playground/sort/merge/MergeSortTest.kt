package com.daniel.goncharov.algorithm.playground.sort.merge

import org.junit.Test


class MergeSortTest {

    @Test fun shouldSortEven() {
        val sort = intArrayOf(9, 1, 5, 7, 2, 0, 3, 4)
        val output = MergeSort().mergeSort(sort)
        println(output.asList())
    }

    @Test fun shouldSortOdd() {
        val sort = intArrayOf(9, 1, 5, 7, 2, 0, 3)
        val output = MergeSort().mergeSort(sort)
        println(output.asList())
    }

    @Test fun shouldOne() {
        val sort = intArrayOf(9)
        val output = MergeSort().mergeSort(sort)
        println(output.asList())
    }

    @Test fun shouldTwo() {
        val sort = intArrayOf(1, 2)
        val output = MergeSort().mergeSort(sort)
        println(output.asList())
    }

    @Test fun shouldThree() {
        val sort = intArrayOf(7, 1, 2)
        val output = MergeSort().mergeSort(sort)
        println(output.asList())
    }

}