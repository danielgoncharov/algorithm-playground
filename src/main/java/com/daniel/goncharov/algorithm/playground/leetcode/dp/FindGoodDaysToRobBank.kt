package com.daniel.goncharov.algorithm.playground.leetcode.dp

class FindGoodDaysToRobBank {

    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        val table = MutableList(time + 1) { row ->
            MutableList(security.size + 2) { column ->
                if (column == 0 || column == security.size + 1) {
                    false
                } else row == 0
            }
        }

        val result = mutableListOf<Int>()
        for (i in 1 until time + 1) {
            for (j in 1 until security.size + 1) {
                if (i == time) {
                    table[i][j] = table[i - 1][j - 1] &&
                            table[i - 1][j] &&
                            table[i - 1][j + 1] &&
                            security[j - 2] >= security[j - 1] && security[j - 1] <= security[j + 1]
                } else {
                    table[i][j] =
                }
                if (i == time && table[i][j]) {
                    result.add(j - 1)
                }
            }
        }

        return result
    }


}