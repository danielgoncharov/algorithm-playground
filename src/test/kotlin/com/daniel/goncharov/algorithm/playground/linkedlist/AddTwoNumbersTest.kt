package com.daniel.goncharov.algorithm.playground.linkedlist

import com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist.ListCycle
import com.daniel.goncharov.algorithm.playground.interviewbit.linkedlist.ListNode
import org.junit.Test

class AddTwoNumbersTest {
    @Test
    fun test1() {
        val listNode1 = ListNode(0)
        val listNode2 = ListNode(1)
        val listNode3 = ListNode(2)
        val listNode4 = ListNode(4)
        val listNode5 = ListNode(5)
        listNode1.next = listNode2
        listNode2.next = listNode3
        listNode3.next = listNode4
        listNode4.next = listNode5
        listNode5.next = listNode1
        val result = ListCycle().detectCycle(listNode1)
    }
}