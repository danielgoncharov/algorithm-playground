package com.daniel.goncharov.algorithm.playground.leetcode.dp

class LongestPalindromicSubstring {
    fun longestPalindrome(string: String): String {
        return longestPalindromeTopToBottom(string)
    }

    private fun longestPalindromeTopToBottom(string: String): String {
        val cache = Array(string.length) { BooleanArray(string.length) }
        for (i in string.indices) {
            cache[i][i] = true
        }

        var left = 0
        var right = 0
        var maxDiff = Int.MIN_VALUE
        //https://myinterview.guru/leetcode-5-longest-palindromic-substring-17717b5db2c2
        for (i in 1 until string.length) {
            for (j in 0 until string.length - i) {
                if (i == 1) { // only two items in the interval
                    cache[j][j + i] = string[j + 1] == string[j]
                } else {
                    cache[j][j + i] = string[j] == string[j + i] && cache[j + 1][j + i - 1]
                }

                if (cache[j][j + i] && i > maxDiff) {
                    maxDiff = i
                    left = j
                    right = i + j
                }
            }
        }
        return string.substring(left, right + 1)
    }

    private fun longestPalindromeRec() {

    }
}
//
//else if (i % 2 == 1) { // even number, we need to compare sides and internal part
//    cache[j][j + i] = string[j + i] == string[j] && cache[j + 1][j + i - 1]
//}
//
//else { // odd number, we need to compare sides and internal part
//    cache[j][j + i] = string[j + i] == string[j] && cache[j + 1][j + i - 1]
//}