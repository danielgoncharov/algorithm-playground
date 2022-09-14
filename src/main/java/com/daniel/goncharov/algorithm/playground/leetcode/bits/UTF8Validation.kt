package com.daniel.goncharov.algorithm.playground.leetcode.bits

class UTF8Validation {

    fun validUtf8(bytes: IntArray): Boolean {
        var mainByteIndex = 0
        while (mainByteIndex < bytes.size) {

            val bytesToCheck = if (bytes[mainByteIndex].shr(3).xor(30) == 0) {
                3
            } else if (bytes[mainByteIndex].shr(4).xor(14) == 0) {
                2
            } else if (bytes[mainByteIndex].shr(5).xor(6) == 0) {
                1
            } else if (bytes[mainByteIndex].shr(7) == 0) {
                mainByteIndex++
                continue
            } else {
                return false
            }

            val start = mainByteIndex + 1
            var trailingIndex = start
            while (trailingIndex < start + bytesToCheck) {
                if (trailingIndex >= bytes.size || bytes[trailingIndex].shr(6) != 2) return false
                trailingIndex++
                mainByteIndex = trailingIndex

            }
        }
        return true
    }


}