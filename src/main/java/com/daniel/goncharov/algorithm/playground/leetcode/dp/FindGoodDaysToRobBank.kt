package com.daniel.goncharov.algorithm.playground.leetcode.dp

class FindGoodDaysToRobBank {

    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {

        val prefixDec = MutableList(security.size) { 0 }
        for (i in 1 until security.size) {
            if (security[i - 1] >= security[i]) {
                prefixDec[i] = prefixDec[i - 1] + 1
            }
        }
        val sufInc = MutableList(security.size) { 0 }
        for (i in security.size - 2 downTo 0) {
            if (security[i + 1] >= security[i]) {
                sufInc[i] = sufInc[i + 1] + 1
            }
        }

        val result = mutableListOf<Int>()
        for (i in security.indices) {
            if (prefixDec[i] >= time && sufInc[i] >= time) {
                result.add(i)
            }
        }
        return result
    }

}