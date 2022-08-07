package com.daniel.goncharov.algorithm.playground.leetcode.dp

class MaximumEarningsFromTaxi {

    fun maxTaxiEarnings(endStop: Int, rides: Array<IntArray>): Long {
        val typedRides = rides.map { ride -> Ride(ride[0], ride[1], ride[2]) }
        return calculateEarning(StartRide, endStop, typedRides)
    }

    private fun calculateEarning(currentRide: Ride, endStop: Int, rides: List<Ride>): Long {
        val maxLaterRideProfit = rides
            .filter { rideToFilter -> rideToFilter.start >= currentRide.end }
            .map { newRide ->
                calculateEarning(
                    newRide,
                    endStop,
                    rides
                )
            }
            .maxOrNull() ?: 0L
        return currentRide.profit + maxLaterRideProfit
    }
}

data class Ride(val start: Int, val end: Int, val tip: Int) {
    val profit = end - start + tip

}

val StartRide = Ride(0, 0, 0)
