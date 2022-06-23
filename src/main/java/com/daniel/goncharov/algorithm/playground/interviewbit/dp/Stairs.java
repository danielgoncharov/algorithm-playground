package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class Stairs {

    public int climbStairs(int numStairs) {
        if (numStairs <= 0) return 0;
        int[] array = new int[numStairs + 1];
        array[0] = 1;
        array[1] = 1;
        for (int index = 2; index < array.length; index++) {
            array[index] = array[index - 1] + array[index - 2];
        }
        return array[numStairs];
    }
}
