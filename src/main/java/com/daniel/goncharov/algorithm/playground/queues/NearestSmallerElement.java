package com.daniel.goncharov.algorithm.playground.queues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : input) {
            while (!stack.isEmpty() && stack.peek() >= integer) stack.pop();
            if (stack.isEmpty()) result.add(-1);
            else result.add(stack.peek());
            stack.push(integer);
        }
        return result;
    }
}
