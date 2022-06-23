package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    public String fractionToDecimal(int numeratorIn, int denominatorIn) {
        long numerator = numeratorIn, denominator = denominatorIn;
        if (numerator % denominator == 0) return String.valueOf(numerator / denominator);
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) result.append("-");
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        result.append(numerator / denominator + ".");
        numerator = (numerator % denominator) * 10;
        while (!map.containsKey(numerator)) {
            map.put(numerator, result.length());
            result.append(numerator / denominator);
            numerator = (numerator % denominator) * 10;
            if (numerator == 0) return result.toString();
        }
        return result.insert(map.get(numerator), "(").append(")").toString();
    }
}
