package com.daniel.goncharov.algorithm.playground.leetcode.stacks

import java.util.*

class MaximumNestingDepthOfTwoValidParenthesesStrings {

    fun maxDepthAfterSplit(seq: String): IntArray {
        //using stack check if the string is valid vps. use stack for saving index + parenteses, push and pop until empty. Once empty
        // construct block, split block in half and assign A and B. Process rest of the string
        val stack = Stack<Char>()
        var start = 0
        val resultList = MutableList(seq.length) { 0 }
        for (index in seq.indices) {
            val character = seq[index]
            if (character == ')') {
                stack.pop()
            } else {
                stack.add(character)
            }
            if (stack.isEmpty()) {
                val subseq = seq.subSequence(start, index + 1)
                annotateVps(subseq, start, index, resultList)
                start = index + 1
            }

        }
        return resultList.toIntArray()
    }

    private fun annotateVps(
        subseq: CharSequence,
        start: Int,
        index: Int,
        resultList: MutableList<Int>
    ) {


    }

}