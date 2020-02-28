package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.ArrayList;
import java.util.List;

public class Diffk2 {
    public int diffPossible(final List<Integer> numbers, int diff) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int curr = numbers.get(i);

            int ai = curr + diff;

            int aj = curr - diff;

            if (list.contains(ai) || list.contains(aj)) return 1;
            list.add(curr);
        }

        return 0;

    }
}
