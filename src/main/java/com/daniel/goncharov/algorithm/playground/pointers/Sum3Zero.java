package com.daniel.goncharov.algorithm.playground.pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sum3Zero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> input) {
        int low, high, mid;
        Collections.sort(input);
        int size = input.size();
        Map<String, ArrayList<Integer>> mapOfResults = new HashMap<>();
        int sum;
        for (low = 0; low < size - 2; low++) {
            mid = low + 1;
            high = size - 1;

            while (mid < high) {

                sum = input.get(low) + input.get(mid) + input.get(high);
                if (sum < 0) {
                    mid++;
                    continue;
                }
                if (sum > 0) {
                    high--;
                    continue;
                }
                String key = input.get(low) + "" + input.get(mid) + "" + input.get(high);
                if (!mapOfResults.containsKey(key)) {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(input.get(low));
                    result.add(input.get(mid));
                    result.add(input.get(high));
                    mapOfResults.put(key, result);
                }
                mid++;
                high--;
            }

        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : mapOfResults.entrySet()) {
            finalResult.add(entry.getValue());
        }
        return finalResult;
    }
}
