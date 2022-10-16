package com.daniel.goncharov.algorithm.playground.leetcode.dp


class NumberOfWaysToSelectBuildings {

    fun numberOfWays(buildingsPlan: String): Long {
        val count0 = count(buildingsPlan, '0')
        val count1 = count(buildingsPlan, '1')
        val count01 = count(buildingsPlan, '1', count0, 1)
        val count10 = count(buildingsPlan, '0', count1, 1)

        val count101 = count(buildingsPlan, '1', count10, 2)
        val count010 = count(buildingsPlan, '0', count01, 2)

        return count101.last() + count010.last()

    }

    private fun count(
        buildingsPlan: String,
        element: Char,
        countElements: MutableList<Long>,
        startIndex: Int
    ): MutableList<Long> {
        val countArray = MutableList(buildingsPlan.length) { 0L }
        for (index in startIndex until buildingsPlan.length) {
            val character = buildingsPlan[index]
            if (character == element) {
                countArray[index] = if (index == 0) 1 else countArray[index - 1] + countElements[index]
            } else {
                countArray[index] = if (index == 0) 0 else countArray[index - 1]
            }
        }
        return countArray
    }

    private fun count(buildingsPlan: String, element: Char): MutableList<Long> {
        val countArray = MutableList(buildingsPlan.length) { 0L }
        var count = 0L
        buildingsPlan.forEachIndexed { index: Int, char: Char ->
            if (char == element) {
                count++;
                countArray[index] = count
            } else {
                countArray[index] = if (index == 0) 0 else countArray[index - 1]
            }
        }
        return countArray
    }
}




