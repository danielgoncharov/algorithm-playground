package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;
import java.util.Collections;

public class TusharBirthdayBombs {

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        int min = Collections.min(B);
        int available = A % min;
        int i = 0;
        ArrayList<Integer> resp = new ArrayList<>();
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
