package com.daniel.goncharov.algorithm.playground.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {

    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        Collections.sort(mice);
        Collections.sort(holes);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mice.size(); i++) {
            int diff = Math.abs(holes.get(i) - mice.get(i));
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}
