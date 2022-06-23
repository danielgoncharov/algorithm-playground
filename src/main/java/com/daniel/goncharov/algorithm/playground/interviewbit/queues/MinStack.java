package com.daniel.goncharov.algorithm.playground.interviewbit.queues;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack = new Stack<Integer>();
    Integer minEle;

    public void push(int x) {
        if (minStack.isEmpty()) {
            minEle = x;
            minStack.push(x);
            return;
        }

        if (x < minEle) {
            minStack.push(2 * x - minEle);
            minEle = x;
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.isEmpty()) return;
        int currentTop = minStack.pop();
        if (currentTop < minEle) {
            minEle = 2 * minEle - currentTop;
        }
    }

    public int top() {
        if (minStack.isEmpty()) return -1;
        int currentTop = minStack.peek();
        if (currentTop < minEle) return minEle;
        return currentTop;
    }

    int getMin() {
        if (minStack.isEmpty()) return -1;
        return minEle;
    }
}
