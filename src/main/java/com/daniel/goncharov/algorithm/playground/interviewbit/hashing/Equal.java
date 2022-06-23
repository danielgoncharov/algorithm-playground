package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Pair> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            int left = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                int right = numbers.get(j);
                int sum = left + right;
                if (!hashMap.containsKey(sum)) {
                    hashMap.put(sum, new Pair(i, j));
                    continue;
                }
                Pair pair = hashMap.get(sum);
                if (i == pair.i || i == pair.j || j == pair.i || j == pair.j) continue;
                if (result.size() == 0) {
                    result.add(pair.i);
                    result.add(pair.j);
                    result.add(i);
                    result.add(j);
                    continue;
                }
                if (pair.i < result.get(0)
                        || (pair.i == result.get(0) && pair.j < result.get(1))
                        || (pair.i == result.get(0) && pair.j == result.get(1) && i < result.get(2))
                        || (pair.i == result.get(0) && pair.j == result.get(1) && i == result.get(2)) && j < result.get(3)
                ) {
                    result.clear();
                    result.add(pair.i);
                    result.add(pair.j);
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }

    static class Pair {
        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
