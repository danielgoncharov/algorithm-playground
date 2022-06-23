package com.daniel.goncharov.algorithm.playground.interviewbit.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(final List<Integer> items) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int resultCount = Integer.MIN_VALUE;
        for (int i = 0; i < items.size(); i++) {
            int item = items.get(i);
            int count;
            if (map.containsKey(item)) {
                count = map.get(item) + 1;
            } else {
                count = 1;
            }
            map.put(item, count);
            if (count > resultCount) {
                result = item;
                resultCount = count;
            }
        }
        return result;
    }
}
