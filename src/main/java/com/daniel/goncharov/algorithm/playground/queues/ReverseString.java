package com.daniel.goncharov.algorithm.playground.queues;

import java.util.Stack;

public class ReverseString {

    public String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < input.length(); index++) {
            stack.push(input.charAt(index));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
