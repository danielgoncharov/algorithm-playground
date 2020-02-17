package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum2 {

    public ArrayList<Integer> twoSum(final List<Integer> numbers, int targetNumber) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        for (int index = 0; index < numbers.size(); index++) {
            int currentNumber = numbers.get(index);
            if (!numbersMap.containsKey(currentNumber)) numbersMap.put(currentNumber, index);
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (numbersMap.size() == 1 && numbers.size() > 1) {
            result.add(1);
            result.add(2);
            return result;
        }
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MAX_VALUE;
        for (int index = 0; index < numbers.size(); index++) {
            int currentNumber = numbers.get(index);
            int numberToLook = targetNumber - currentNumber;
            Integer foundIndex = numbersMap.get(numberToLook);
            if (foundIndex == null || index == foundIndex || index > foundIndex) continue;
            if (foundIndex < rightIndex || (foundIndex == rightIndex && index < leftIndex)) {
                result.clear();
                result.add(index + 1);
                result.add(foundIndex + 1);
                leftIndex = index;
                rightIndex = foundIndex;
            }
        }
        return result;
    }
}
