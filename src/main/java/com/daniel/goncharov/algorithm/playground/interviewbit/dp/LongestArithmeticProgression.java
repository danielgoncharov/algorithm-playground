package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestArithmeticProgression {

    public int solve(final List<Integer> numbers) {
        int size = numbers.size();
        int max = 1;
        if (size > 1) {
            max = 2;
        }
        ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dp.add(new HashMap<>());
        }
        for (int i = 1; i < numbers.size(); i++) {
            HashMap<Integer, Integer> hmi = dp.get(i);
            for (int j = 0; j < i; j++) {
                HashMap<Integer, Integer> hmj = dp.get(j);
                int diff = numbers.get(i) - numbers.get(j);
                if (hmj.containsKey(diff)) {
                    hmi.put(diff, hmj.get(diff) + 1);
                    max = Math.max(hmi.get(diff), max);
                } else {
                    hmi.put(diff, 2);
                }
            }
        }
        return max;
    }
}
