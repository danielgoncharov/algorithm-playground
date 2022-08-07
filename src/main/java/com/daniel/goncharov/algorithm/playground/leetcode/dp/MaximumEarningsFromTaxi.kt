package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class MaximumEarningsFromTaxi {

    fun maxTaxiEarnings(endStop: Int, rides: Array<IntArray>): Long {
        val cache = MutableList(endStop + 1) { 0L }
        rides.map { ride -> Ride(ride[0], ride[1], ride[2]) }
            .sortedBy { it.start }
            .forEach { ride ->
                cache[ride.end] = max(cache[ride.end], ride.profit + maxFrom(ride.start, cache))
            }

        return cache.maxOrNull() ?: 0
    }

    private fun maxFrom(start: Int, cache: MutableList<Long>): Long {
        var maxFrom = Long.MIN_VALUE
        for (index in 0 until start + 1) {
            maxFrom = max(maxFrom, cache[index])
        }
        return maxFrom
    }

}

data class Ride(val start: Int, val end: Int, val tip: Int) {
    val profit = end - start + tip
}

