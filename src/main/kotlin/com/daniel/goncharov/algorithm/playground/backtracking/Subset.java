package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(numbers);
        findSubset(0, numbers, new ArrayList<>(), result);
        return result;
    }

    public void findSubset(
            int currentIndex,
            ArrayList<Integer> numbers,
            ArrayList<Integer> set,
            ArrayList<ArrayList<Integer>> result
    ) {
        if (currentIndex == numbers.size()) {
            result.add(set);
            return;
        }
        findSubset(
                currentIndex + 1,
                numbers,
                set,
                result
        );
        ArrayList<Integer> setWithElement = new ArrayList<>(set);
        setWithElement.add(numbers.get(currentIndex));
        findSubset(
                currentIndex + 1,
                numbers,
                setWithElement,
                result
        );

    }

}
