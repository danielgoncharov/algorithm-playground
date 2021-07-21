package com.daniel.goncharov.algorithm.playground.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

    public int trap(final List<Integer> levels) {
        Stack<Integer> picksStack = new Stack<>();
        int watterAmount = getLevel(levels, picksStack);
        if (picksStack.isEmpty()) return watterAmount;
        List<Integer> leftovers = new ArrayList<>();
        while (!picksStack.isEmpty()) leftovers.add(picksStack.pop());
        return getLevel(leftovers, new Stack<>()) + watterAmount;
    }

    private int getLevel(final List<Integer> levels, Stack<Integer> picksStack) {
        int trappedWater = 0;
        int lastMax = 0;
        for (Integer level : levels) {
            if (picksStack.isEmpty()) {
                lastMax = level;
            } else if (level >= lastMax) {
                while (picksStack.peek() != lastMax) {
                    trappedWater += Math.min(lastMax, level) - picksStack.pop();
                }
                picksStack.pop();
                lastMax = level;
            }
            picksStack.push(level);

        }
        return trappedWater;
    }
}
