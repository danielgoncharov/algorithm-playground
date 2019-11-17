package com.daniel.goncharov.algorithm.playground.stacks.queues;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public String simplifyPath(String input) {
        String[] directories = input
                .trim()
                .replaceAll("/+", "/")
                .split("/");
        Stack<String> stack = new Stack<>();
        for (String directory : directories) {
            if(directory.isEmpty()) continue;
            if (directory.equals(".")) continue;
            if (!directory.equals("..")) {
                stack.push(directory);
                continue;
            }
            if (!stack.isEmpty()) stack.pop();
        }


        if (stack.isEmpty()) return "/";

        Stack<String> resultStack = new Stack<>();
        while (!stack.isEmpty()) {
            resultStack.push(stack.pop());
        }


        StringBuilder result =new StringBuilder();
        while (!resultStack.isEmpty()) {
            result.append("/").append(resultStack.pop());
        }
        return result.toString();
    }

}
