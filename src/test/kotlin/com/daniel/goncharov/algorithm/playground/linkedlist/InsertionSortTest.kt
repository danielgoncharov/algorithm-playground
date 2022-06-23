package com.daniel.goncharov.algorithm.playground.linkedlist

import com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist.InsertionSort
import org.junit.Test

class InsertionSortTest {
    @Test
    fun test1() {
        val listA = arrayListOf(6, 7, 1, 4, 3, 0).toLinkedList()
        val result = InsertionSort()
            .insertionSortList(listA)
    }
}