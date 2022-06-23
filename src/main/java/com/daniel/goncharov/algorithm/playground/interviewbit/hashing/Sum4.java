package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;

public class Sum4 {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> numbers, int target) {
        Collections.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 3; i++) {
            for (int j = i + 1; j < numbers.size() - 2; j++) {
                int sumToFind = target - numbers.get(i) - numbers.get(j);
                int left = j + 1;
                int right = numbers.size() - 1;
                while (left < right) {
                    if (numbers.get(left) + numbers.get(right) > sumToFind) right--;
                    else if (numbers.get(left) + numbers.get(right) < sumToFind) left++;
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(numbers.get(i));
                        temp.add(numbers.get(j));
                        temp.add(numbers.get(left));
                        temp.add(numbers.get(right));
                        if (!result.contains(temp)) result.add(temp);
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
