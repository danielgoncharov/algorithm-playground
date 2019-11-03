package com.daniel.goncharov.algorithm.playground.linkedlist

import org.junit.Test

class KReverseLinkedListTest {
    @Test
    fun test1() {
        val listA = arrayListOf(6 , 10 , 0 , 3, 4 , 8).toLinkedList()
        val result = KReverseLinkedList().reverseList(listA, 3)
    }
}