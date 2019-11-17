package com.daniel.goncharov.algorithm.playground.stacks.queues;

import java.util.Stack;

public class RedundantBraces {

    public int braces(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (char character : charArray) {
            if (character != ')') {
                stack.push(character);
                continue;
            }
            char top = stack.pop();
            int flag = 1;
            while (top != '(') {
                if (top == '+' || top == '-'
                        || top == '*' || top == '/') {
                    flag = 0;
                }
                top = stack.pop();
            }
            if (flag == 1) {
                return 1;
            }

        }
        return 0;
    }
}
