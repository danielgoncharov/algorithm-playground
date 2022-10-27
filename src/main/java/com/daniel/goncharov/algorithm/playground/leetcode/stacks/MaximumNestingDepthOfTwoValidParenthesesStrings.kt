package com.daniel.goncharov.algorithm.playground.leetcode.stacks

import java.util.*

class MaximumNestingDepthOfTwoValidParenthesesStrings {

    fun maxDepthAfterSplit(seq: String): IntArray {
        val stack = Stack<StackElement>()
        val resultList = MutableList(seq.length) { 0 }
        for (index in seq.indices) {
            val character = seq[index]
            val element = if (character == ')') {
                stack.pop()
            } else {
                val element = StackElement.createOpening(stack)
                stack.add(element)
                element
            }
            resultList[index] = element.level % 2
        }
        return resultList.toIntArray()
    }

    data class StackElement(val level: Int, val character: Char) {
        companion object Apply {
            fun createOpening(stack: Stack<StackElement>): StackElement {
                return if (stack.isEmpty()) {
                    StackElement(0, '(')
                } else if (stack.peek().character == ')') {
                    StackElement(stack.peek().level, '(')
                } else {
                    StackElement(stack.peek().level + 1, '(')
                }
            }
        }
    }


}