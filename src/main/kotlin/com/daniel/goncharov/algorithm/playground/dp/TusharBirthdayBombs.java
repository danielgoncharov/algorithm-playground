package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;

public class TusharBirthdayBombs {

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> resp = new ArrayList<>();
        int min = Collections.min(B);
        int available = A % min;

        int i = 0;
        while (resp.size() < A / min) {
            if (B.get(i) - min <= available) {
                available -= B.get(i) - min;
                resp.add(i);
            } else {
                i++;
            }
        }
        return resp;
    }


}
