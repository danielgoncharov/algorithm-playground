package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.ArrayList;
import java.util.List;

public class ColorfulNumber {

    public int colorful(int number) {
        String stringNumber = String.valueOf(number);
        List<Integer> products = new ArrayList<>();
        for (int i = 0; i < stringNumber.length(); i++) {
            int product = 1;
            for (int j = i; j < stringNumber.length(); j++) {
                int currentNumber = Character.getNumericValue(stringNumber.charAt(j));
                product *= currentNumber;
                if (products.contains(product)) return 0;
                products.add(product);
            }
        }
        return 1;
    }
}
