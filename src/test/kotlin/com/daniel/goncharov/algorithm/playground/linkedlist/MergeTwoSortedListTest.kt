package com.daniel.goncharov.algorithm.playground.linkedlist

import com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist.MergeTwoSortedList
import org.junit.Test

class MergeTwoSortedListTest {
    @Test
    fun test1() {
        val listA = arrayListOf(1, 3, 5, 7).toLinkedList()
        val listB = arrayListOf(2, 4, 6, 8).toLinkedList()
        val result = MergeTwoSortedList()
            .mergeTwoLists(listA, listB)
    }
}