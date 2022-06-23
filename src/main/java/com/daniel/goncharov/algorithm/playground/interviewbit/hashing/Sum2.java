package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum2 {

    public ArrayList<Integer> twoSum(final List<Integer> numbers, int sum2Goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int index = 0; index < numbers.size(); index++) {
            int curr = numbers.get(index);

            if (map.containsKey(sum2Goal - curr)) {
                Integer foundIndex = map.get(sum2Goal - curr);
                result.add(foundIndex);
                result.add(index + 1);
                return result;
            } else if (!map.containsKey(curr)) {
                map.put(curr, index + 1);
            }
        }

        return result;
    }
}
