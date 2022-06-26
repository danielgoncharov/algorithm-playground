package com.daniel.goncharov.algorithm.playground.leetcode.dp

class LongestPalindromicSubstring {

    fun longestPalindrome(string: String): String {
        return longestPalindromeTopToBottom(string)
    }

    var max = 0
    var left = 0
    var right = 0

    private fun longestPalindromeRec(string: String): String {
        for (i in string.indices) {
            checkString(string, i, i + 1)
            checkString(string, i - 1, i + 1)
        }
        return string.substring(left, right + 1)
    }

    private fun checkString(
        string: String,
        leftIndex: Int,
        rightIndex: Int
    ) {
        if (leftIndex < 0 || rightIndex == string.length) return
        if (string[leftIndex] != string[rightIndex]) return
        val diff = rightIndex - leftIndex
        if (diff > max) {
            left = leftIndex
            right = rightIndex
            max = diff
        }
        checkString(string, leftIndex - 1, rightIndex + 1)
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
}
//
//else if (i % 2 == 1) { // even number, we need to compare sides and internal part
//    cache[j][j + i] = string[j + i] == string[j] && cache[j + 1][j + i - 1]
//}
//
//else { // odd number, we need to compare sides and internal part
//    cache[j][j + i] = string[j + i] == string[j] && cache[j + 1][j + i - 1]
//}