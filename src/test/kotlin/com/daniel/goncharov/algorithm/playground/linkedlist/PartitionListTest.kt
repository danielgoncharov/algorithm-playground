package com.daniel.goncharov.algorithm.playground.linkedlist

import org.junit.Test

class PartitionListTest {
    @Test
    fun test1() {
        val listA = arrayListOf(1, 2, 3, 4, 5).toLinkedList()
        val result = PartitionList().partition(listA, 5)
    }
}