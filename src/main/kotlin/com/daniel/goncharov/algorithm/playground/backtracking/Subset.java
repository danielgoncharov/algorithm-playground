package com.daniel.goncharov.algorithm.playground.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> numbers) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        if (numbers.size() == 0) return output;
        Collections.sort(numbers);
        generate(numbers, output, new ArrayList<>(), 0);
        return output;
    }

    private void generate(
            ArrayList<Integer> numbers,
            ArrayList<ArrayList<Integer>> output,
            ArrayList<Integer> temp,
            int index
    ) {
        for (int i = index; i < numbers.size(); i++) {
            temp.add(numbers.get(i));
            output.add(new ArrayList<>(temp));
            generate(numbers, output, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
