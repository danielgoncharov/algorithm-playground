package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> anagrams) {

        Map<String, ArrayList<Integer>> result = new LinkedHashMap<>();
        for (int index = 0; index < anagrams.size(); index++) {
            String currentString = sortString(anagrams.get(index));
            ArrayList<Integer> indexes = result.getOrDefault(currentString, new ArrayList<>());
            indexes.add(index + 1);
            result.put(currentString, indexes);
        }
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (ArrayList<Integer> set : result.values()) {
            answer.add(new ArrayList<>(set));
        }
        return answer;
    }

    private String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
