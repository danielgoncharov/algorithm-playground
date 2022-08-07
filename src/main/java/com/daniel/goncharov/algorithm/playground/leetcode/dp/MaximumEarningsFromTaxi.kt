package com.daniel.goncharov.algorithm.playground.leetcode.dp

class MaximumEarningsFromTaxi {

    fun maxTaxiEarnings(endStop: Int, rides: Array<IntArray>): Long {
        val cache = HashMap<Int, Long>()
        val typedRides = rides.map { ride -> Ride(ride[0], ride[1], ride[2]) }
        return calculateEarning(StartRide, typedRides, cache)
    }

    private fun calculateEarning(
        currentRide: Ride,
        rides: List<Ride>,
        cache: MutableMap<Int, Long>
    ): Long {
        if (cache.containsKey(currentRide.start)) {
            return cache[currentRide.start] ?: 0
        }
        val maxLaterRideProfit = rides
            .filter { rideToFilter -> rideToFilter.start >= currentRide.end }
            .map { newRide ->
                calculateEarning(
                    newRide,
                    rides,
                    cache
                )
            }
            .maxOrNull() ?: 0L
        cache[currentRide.start] = currentRide.profit + maxLaterRideProfit
        return cache[currentRide.start] ?: 0
    }
}

data class Ride(val start: Int, val end: Int, val tip: Int) {
    val profit = end - start + tip

}

val StartRide = Ride(0, 0, 0)
