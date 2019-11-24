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
            while (!deque.isEmpty() && input.get(deque.peekLast()) <= currentElement) deque.removeLast();
            deque.add(index);
            if (deque.peekFirst() < index - swSize + 1) deque.removeFirst();
            if (index >= swSize - 1) result.add(input.get(deque.peekFirst()));
        }
        return result;
    }
}
