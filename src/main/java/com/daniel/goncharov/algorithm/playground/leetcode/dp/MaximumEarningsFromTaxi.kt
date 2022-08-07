package com.daniel.goncharov.algorithm.playground.leetcode.dp

import kotlin.math.max

class MaximumEarningsFromTaxi {

    fun maxTaxiEarnings(endStop: Int, rides: Array<IntArray>): Long {
        var maxEarnings = Long.MIN_VALUE
        val typedRides = rides.map { ride -> Ride(ride[0], ride[1], ride[2]) }
        typedRides.forEach { startRide ->
            maxEarnings = max(
                maxEarnings,
                calculateEarning(startRide, endStop, typedRides)
            )
        }
        return maxEarnings
    }

    private fun calculateEarning(ride: Ride, endStop: Int, rides: List<Ride>): Long {
        val rideToStart = rides.filter { rideToFilter -> ride.end == rideToFilter.start }

        return (rideToStart.map { newRide ->
            calculateEarning(
                newRide,
                endStop,
                rides
            )
        }
            .maxOrNull() ?: 0L) + ride.profit
    }
}

data class Ride(val start: Int, val end: Int, val tip: Int) {
    val profit = end - start + tip
}