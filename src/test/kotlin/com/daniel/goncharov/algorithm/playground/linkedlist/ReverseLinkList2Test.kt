package com.daniel.goncharov.algorithm.playground.linkedlist

import org.junit.Test


class ReverseLinkList2Test {

    @Test
    fun test1() {
        val listA = arrayListOf(1, 2, 3).toLinkedList()
        val result = ReverseLinkList2().reverseBetween(listA, 1, 2)
    }
}