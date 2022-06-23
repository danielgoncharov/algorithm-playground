package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int start = 0;
        int end = -1;
        for (int index = 0; index < numbers.size(); index++) {
            int currentNumber = numbers.get(index);
            sum += currentNumber;
            if (sum == 0 && index > end - start) {
                start = 0;
                end = index;
                continue;
            }
            Integer currentIndex = map.get(sum);
            if (currentIndex == null) {
                map.put(sum, index);
                continue;
            }
            if (index - currentIndex - 1 > end - start) {
                start = currentIndex + 1;
                end = index;
            }
        }
        for (int index = start; index <= end; index++) {
            result.add(numbers.get(index));
        }
        return result;
    }
}
