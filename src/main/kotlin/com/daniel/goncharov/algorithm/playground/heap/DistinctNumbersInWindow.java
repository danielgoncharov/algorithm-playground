package com.daniel.goncharov.algorithm.playground.heap;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> integers, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        if (windowSize > integers.size()) return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = windowSize - 1;
        for (int index = left; index < right; index++) {
            addNewValue(integers, map, index);
        }
        while (right < integers.size()) {
            addNewValue(integers, map, right);

            result.add(map.size());

            int key = integers.get(left);
            int value = map.get(key);
            if (value == 1) {
                map.remove(key);
            } else {
                map.put(key, value - 1);
            }
            left++;
            right++;
        }
        return result;
    }

    private void addNewValue(ArrayList<Integer> integers, HashMap<Integer, Integer> map, int index) {
        int key = integers.get(index);
        int newValue = map.getOrDefault(key, 0) + 1;
        map.put(key, newValue);
    }
}
