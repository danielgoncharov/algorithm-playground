package com.daniel.goncharov.algorithm.playground.linkedlist

import org.junit.Test

class AddTwoNumbersTest {
    @Test
    fun test1() {
        val listA = arrayListOf(9, 9, 1).toLinkedList()
        val listB = arrayListOf(9, 9, 9).toLinkedList()
        val result = AddTwoNumbers().addTwoNumbers(listA, listB)
    }
}