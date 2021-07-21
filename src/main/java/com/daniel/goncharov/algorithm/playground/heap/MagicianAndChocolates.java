package com.daniel.goncharov.algorithm.playground.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public int nchoc(int timeUnits, ArrayList<Integer> buckets) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(buckets);
        int result = 0;
        for (int currentTime = 0; currentTime < timeUnits; currentTime++) {
            int max = heap.poll();
            result = (int) (((long)result + (long)max) % 1000000007);
            heap.add((int) Math.floor(max / 2.0));
        }
        return result;
    }
}
