package com.daniel.goncharov.algorithm.playground.leetcode.string

class PrintWordsVertically {

    fun printVertically(input: String): List<String> {
        val words = input.split("\\s".toRegex())
        val maxSize = words.maxBy(String::length)?.length ?: 0
        val result = mutableListOf<String>()
        for (index in 0 until maxSize) {
            words.map { it.getOrNull(index) ?: ' ' }
                .joinToString("")
                .trimEnd()
                .apply { result.add(this) }
        }
        return result
    }
}