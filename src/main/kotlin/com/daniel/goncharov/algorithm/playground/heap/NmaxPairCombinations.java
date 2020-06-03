package com.daniel.goncharov.algorithm.playground.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NmaxPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        PriorityQueue<Integer> maxHeapA = new PriorityQueue<>((Integer o1, Integer o2) -> (-Integer.compare(o1, o2)));
        maxHeapA.addAll(arrayA);
        PriorityQueue<Integer> maxHeapB = new PriorityQueue<>((Integer o1, Integer o2) -> (-Integer.compare(o1, o2)));
        maxHeapB.addAll(arrayB);

        ArrayList<Integer> result = new ArrayList<>();
        int aElement = maxHeapA.poll();
        int bElement = maxHeapB.poll();
        while (result.size() != arrayA.size()) {
            result.add(aElement + bElement);
            if (aElement > bElement) {
                if (maxHeapA.peek() + bElement > aElement + maxHeapB.peek()) {
                    aElement = maxHeapA.poll();
                } else {
                    bElement = maxHeapB.poll();
                }
            } else {
                if (maxHeapB.peek() + aElement > bElement + maxHeapA.peek()) {
                    bElement = maxHeapB.poll();
                } else {
                    aElement = maxHeapA.poll();
                }
            }
        }
        return result;
    }
}
