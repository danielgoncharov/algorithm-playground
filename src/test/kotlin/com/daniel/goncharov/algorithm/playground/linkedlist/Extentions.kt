package com.daniel.goncharov.algorithm.playground.linkedlist

fun List<Int>.toLinkedList(): ListNode {
    var head: ListNode? = null
    var nextNode: ListNode? = null
    for ((index, value) in this.withIndex()) {
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

fun ListNode.toList(): List<Int> {
    TODO()
}

