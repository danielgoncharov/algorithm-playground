package com.daniel.goncharov.algorithm.playground.pointers;

import java.util.ArrayList;
import java.util.Collections;

public class Sum3 {

        public int threeSumClosest(ArrayList<Integer> input, int target) {
            int low, high, mid;
            Collections.sort(input);
            int size = input.size();
            int result = input.get(0) + input.get(1) + input.get(2);
            if (size == 3) return result;
            int sum;
            for (low = 0; low < size - 2; low++) {
                mid = low + 1;
                high = size - 1;

                while (mid < high) {

                    sum = input.get(low) + input.get(mid) + input.get(high);

                    if (sum == target)
                        return target;
                    else if (sum < target) {
                        mid++;
                    } else {
                        high--;
                    }

                    int diff = Math.abs(sum - target);
                    int otherDiff = Math.abs(result - target);

                    if (diff < otherDiff)
                        result = sum;

                }

            }


            return result;


        }
}


