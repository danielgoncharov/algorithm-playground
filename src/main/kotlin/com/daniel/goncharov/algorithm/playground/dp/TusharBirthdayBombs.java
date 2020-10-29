package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.Collections;

public class TusharBirthdayBombs {

    public ArrayList<Integer> solve(int limit, ArrayList<Integer> hits) {

        int min = Collections.min(hits);
        int minIndex = hits.indexOf(min);
        int repeats = limit / min;
        int totalStrengh = repeats * min;

        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < minIndex) {
            int currentElement = hits.get(index);
            int tryLex = totalStrengh - min + currentElement;
            if (tryLex == limit) {
                repeats--;
                result.add(index);
                break;
            } else if (tryLex < limit) {
                repeats--;
                totalStrengh = tryLex;
                result.add(index);
            } else {
                index++;
            }
        }
        for (int i = 0; i < repeats; i++) {
            result.add(min);
        }
        return result;
    }


}
