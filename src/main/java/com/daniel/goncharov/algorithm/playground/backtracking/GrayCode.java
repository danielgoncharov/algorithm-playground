package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int numberOfBits) {
        int maxNumber = (int) Math.pow(2, numberOfBits);
        ArrayList<Integer> result = new ArrayList<>();
        for (int number = 0; number < maxNumber; number++) {
            result.add(number ^ number >> 1);
        }
        return result;
    }

}
