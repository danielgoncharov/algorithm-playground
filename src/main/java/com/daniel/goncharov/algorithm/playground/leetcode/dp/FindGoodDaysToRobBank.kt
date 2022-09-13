package com.daniel.goncharov.algorithm.playground.leetcode.dp

class FindGoodDaysToRobBank {

    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        val result = mutableListOf<Int>()

        for (i in security.indices) {
            if (isGoodDay(i, security, time)) {
                result.add(i)
            }
        }

        return result
    }

    private fun isGoodDay(day: Int, security: IntArray, time: Int): Boolean {
        if (day - time < 0 || day + time >= security.size) return false
        var current = security[day]
        for (i in day + 1 until day + time + 1) {
            if (current > security[i]) {
                return false
            }
            current = security[i]
        }
        current = security[day]
        for (i in day - 1 downTo day - time) {
            if (current > security[i]) {
                return false
            }
            current = security[i]
        }
        return true
    }

}