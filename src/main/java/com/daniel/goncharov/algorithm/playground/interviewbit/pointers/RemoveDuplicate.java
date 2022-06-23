package com.daniel.goncharov.algorithm.playground.interviewbit.pointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicate {

    public int removeDuplicates(ArrayList<Integer> input) {
        int left = 0;
        int count = 1;
        for (int right = 1; right < input.size(); right++) {
            int leftElement = input.get(left);
            int rightElement = input.get(right);
            if (right - left == 1) {
                if (leftElement != rightElement) {
                    left++;
                    count++;
                }
                continue;
            }
            if (leftElement != rightElement) {
                left++;
                input.set(left, rightElement);
                count++;
            }

        }
        List<Integer> result = input.subList(0, count);
        return result.size();
    }


}
