package com.daniel.goncharov.algorithm.playground.strings

import com.daniel.goncharov.algorithm.playground.interviewbit.strings.KnuthMorrisPrattPatternMatching
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class KnuthMorrisPrattPatternMatchingTest {

    @Test
    fun lpsTest1() {
        val sortedList = intArrayOf(0, 0, 0, 0, 1, 2, 3, 1)
        val actualArray = KnuthMorrisPrattPatternMatching()
            .createLpsArray("abcdabca")
        assertThat(actualArray).isEqualTo(sortedList)
    }

    @Test
    fun lpsTest2() {
        val sortedList = intArrayOf(0, 1, 0, 1, 2, 3, 4, 5, 2)
        val actualArray = KnuthMorrisPrattPatternMatching()
            .createLpsArray("aabaabaaa")
        assertThat(actualArray).isEqualTo(sortedList)
    }

    @Test
    fun patternMatchingTest1() {
        val haystack = "babbaaabaaaabbababaaabaabbbbabaaaabbabbabaaaababbabbbaaabbbaaabbbaabaabaaaaababbaaaaaabababbbbba"
        val needle = "bababbbbbbabbbaabbaaabbbaababa"
        val result = KnuthMorrisPrattPatternMatching()
            .findSubstring(haystack, needle)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test1() {
        val input = arrayListOf("What", "must", "be", "shall", "be.")
        val result = KnuthMorrisPrattPatternMatching()
            .fullJustify(input, 12)
        assertThat(result).isEqualTo(arrayListOf("What must be", "shall be.   "))
    }

    @Test
    fun test2() {
        val input = arrayListOf("This", "is", "an", "example", "of", "text", "justification.")
        val result = KnuthMorrisPrattPatternMatching()
            .fullJustify(input, 16)
        assertThat(result).isEqualTo(arrayListOf("This    is    an", "example  of text", "justification.  "))
    }

    @Test
    fun test3() {
        val input = arrayListOf("What", "must", "be", "acknowledgment", "shall", "be")
        val result = KnuthMorrisPrattPatternMatching()
            .fullJustify(input, 16)
        assertThat(result).isEqualTo(arrayListOf(
                "What   must   be",
                "acknowledgment  ",
                "shall be        ")
        )
    }

    @Test
    fun test4() {
        val input = arrayListOf("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do")
        val result = KnuthMorrisPrattPatternMatching()
            .fullJustify(input, 20)
        assertThat(result).isEqualTo(arrayListOf(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ")
        )
    }

}