package com.daniel.goncharov.algorithm.playground.hashing

import com.daniel.goncharov.algorithm.playground.interviewbit.hashing.Diffk2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Diffk2Test {

    @Test
    fun shouldFindGeneric1() {
        val array = arrayListOf(77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0)
        val result = Diffk2()
            .diffPossible(array, 53)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun shouldFindGeneric2() {
        val array = arrayListOf(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29)
        val result = Diffk2()
            .diffPossible(array, 97)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun shouldFindGeneri3() {
        val array = arrayListOf(16, 36, 29, 4, 45, 80, 86, 53, 37, 39, 78, 40, 80, 64, 44, 35, 73, 48, 64, 82, 46, 97, 75, 26, 83, 20, 9, 23, 2, 20, 74, 96, 78, 27, 28, 68, 99, 5, 24, 98, 26, 56, 40, 26, 93, 97, 93, 82, 40, 46, 13, 11, 25, 9, 20, 39, 79, 45, 65, 76, 31)
        val result = Diffk2()
            .diffPossible(array, 67)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun shouldFindGeneri4() {
        val array = arrayListOf(75, 99, 92, 86, 38, 17, 11, 57, 91, 19, 19, 70, 97, 47, 55, 70, 23, 97, 100, 21, 60, 81, 94, 61, 81, 63, 89)
        val result = Diffk2()
            .diffPossible(array, 33)
        assertThat(result).isEqualTo(1)
    }
}