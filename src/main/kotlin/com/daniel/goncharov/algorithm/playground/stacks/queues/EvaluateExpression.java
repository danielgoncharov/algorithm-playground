package com.daniel.goncharov.algorithm.playground.stacks.queues;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class EvaluateExpression {

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public int evalRPN(ArrayList<String> input) {
        Stack<Integer> numbers = new Stack<>();
        for (String string : input) {
            if (isNumeric(string)) {
                numbers.push(Integer.valueOf(string));
                continue;
            }
            int first = numbers.pop();
            int second = numbers.pop();
            if (string.equals("-")) {
                numbers.push(second - first);
            } else if (string.equals("+")) {
                numbers.push(second + first);
            } else if (string.equals("*")) {
                numbers.push(second * first);
            } else if (string.equals("/")) {
                numbers.push(second / first);
            }
        }
        return numbers.pop();
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
