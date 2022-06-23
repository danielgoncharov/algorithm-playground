package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;
import java.util.Collections;

public class ChainOfPairs {

    public int solve(ArrayList<ArrayList<Integer>> pairs) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) result.add(1);
        for (int i = 1; i < pairs.size(); i++) {
            for (int j = 0; j < i; j++) {
                int currentRight = pairs.get(i).get(0);
                int currentLeft = pairs.get(j).get(1);
                if (currentRight > currentLeft) {
                    result.set(i, Math.max(result.get(i),result.get(j)+1));
                }
            }
        }
        return Collections.max(result);
    }
}
