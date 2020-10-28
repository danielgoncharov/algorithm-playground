package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class TusharBirthdayBombs {

    public ArrayList<Integer> solve(int limit, ArrayList<Integer> hits) {
        return solveRec(limit, hits, new ArrayList<>(), 0, new HashMap<>());
    }

    private ArrayList<Integer> solveRec(
            int limit,
            ArrayList<Integer> hits,
            ArrayList<Integer> temp,
            int sum,
            HashMap<Integer, ArrayList<Integer>> cache
    ) {

        if (cache.containsKey(temp.hashCode())) return cache.get(temp.hashCode());
        cache.put(temp.hashCode(), new ArrayList<>(temp));
        ArrayList<Integer> max = new ArrayList<>();
        for (int i = 0; i < hits.size(); i++) {
            int currentElement = hits.get(i);
            int newSum = sum + currentElement;
            if (newSum > limit) continue;
            temp.add(i);
            ArrayList<Integer> result;
            if (newSum < limit) {
                result = solveRec(
                        limit,
                        hits,
                        temp,
                        sum + currentElement,
                        cache
                );
            } else {
                result = temp;
            }
            if (result.size() > max.size()) {
                max.clear();
                max.addAll(result);
            }
            temp.remove(temp.size() - 1);
        }
        return max;
    }
}
