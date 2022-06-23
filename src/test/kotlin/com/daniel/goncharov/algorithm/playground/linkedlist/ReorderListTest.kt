package com.daniel.goncharov.algorithm.playground.linkedlist

import com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist.ReorderList
import org.junit.Test

class ReorderListTest {
    @Test
    fun test1() {
        val listA = arrayListOf(1, 2, 3, 4,5,6,7,8,9).toLinkedList()
        val result = ReorderList().reorderList(listA)
    }
}