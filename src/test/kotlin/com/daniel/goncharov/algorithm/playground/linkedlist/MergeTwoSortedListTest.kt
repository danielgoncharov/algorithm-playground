package com.daniel.goncharov.algorithm.playground.linkedlist

import org.junit.Test
import java.util.*

class MergeTwoSortedListTest {
    @Test
    fun test1() {
        val listA = fromList(arrayListOf(1, 3, 5, 7))
        val listB = fromList(arrayListOf(2, 4, 6, 8))
        val result = MergeTwoSortedList().mergeTwoLists(listA, listB)
    }

    private fun fromList(arrayListOf: ArrayList<Int>): ListNode {
        var head: ListNode? = null
        var nextNode: ListNode? = null
        for ((index, value) in arrayListOf.withIndex()) {
            if (index == 0) {
                head = ListNode(value)
                nextNode = head
            } else {
                nextNode?.next = ListNode(value)
                nextNode = nextNode?.next;
            }
        }
        return head!!
    }
}