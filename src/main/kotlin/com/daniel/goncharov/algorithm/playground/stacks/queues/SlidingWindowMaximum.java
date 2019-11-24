package com.daniel.goncharov.algorithm.playground.stacks.queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

    public ArrayList<Integer> slidingMaximum(final List<Integer> input, int swSize) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            int currentElement = input.get(index);
            while (!deque.isEmpty() && deque.peekFirst() <= (index - swSize) && index >= swSize - 1) {
                deque.pop();
            }
            if (deque.isEmpty() || input.get(deque.peekFirst()) < currentElement) {
                deque.clear();
            } else {
                while (!deque.isEmpty() && input.get(deque.peekLast()) <= currentElement) {
                    deque.pollLast();
                }
            }
            deque.add(index);
            if (index >= swSize - 1) result.add(input.get(deque.peekFirst()));
        }
        return result;
    }
}
