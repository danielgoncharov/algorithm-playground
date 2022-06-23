package com.daniel.goncharov.algorithm.playground.interviewbit.queues;

import java.util.Stack;

public class GenerateAllParentheses {

    public int isValid(String string) {
        Stack<Character> paranthesesStack = new Stack<>();
        for (int index = 0; index < string.length(); index++) {
            Character character = string.charAt(index);
            if (isOpen(character)) {
                paranthesesStack.add(character);
                continue;
            }
            if (paranthesesStack.empty()) return 0;
            Character top = paranthesesStack.peek();
            if (!isOpen(top)) return 0;
            if (
                    (character == ')' && top == '(') ||
                            (character == '}' && top == '{') ||
                            (character == ']' && top == '[')
            ) {
                paranthesesStack.pop();
            } else {
                return 0;
            }
        }
        if (paranthesesStack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isOpen(Character character) {
        return character == '(' || character == '{' || character == '[';
    }

}
