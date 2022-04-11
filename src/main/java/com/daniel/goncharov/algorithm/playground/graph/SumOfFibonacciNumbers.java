package com.daniel.goncharov.algorithm.playground.graph;

public class SumOfFibonacciNumbers {

    public int fibsum(int number) {

        int numberOfItems = 0;
        while (number > 0) {
            number -= findClosesNumber(number);
            numberOfItems++;
        }
        return numberOfItems;
    }

    private int findClosesNumber(int number) {
        int first;
        int second = 1;
        int third = 1;
        while (number >= third) {
            first = second;
            second = third;
            third = first + second;
        }
        return second;
    }
}
