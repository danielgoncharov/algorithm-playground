package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> anagrams) {

        Map<Integer, Set<Integer>> result = new TreeMap<>();
        Set<String> characters = new HashSet<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int index = 0; index < anagrams.size(); index++) {
            String currentString = anagrams.get(index);
            String[] chars = currentString.split("");
            characters.addAll(Arrays.asList(chars));
            int currentHash = characters.hashCode();
            characters.clear();
            if (!indexMap.containsKey(currentHash)) {
                indexMap.put(currentHash, index);
                continue;
            }
            int matchingIndex = indexMap.get(currentHash);
            Set<Integer> indexes = result.getOrDefault(currentHash, new TreeSet<>());
            indexes.add(index + 1);
            indexes.add(matchingIndex + 1);
            result.put(currentHash, indexes);
        }
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (Set<Integer> set : result.values()) {
            answer.add(new ArrayList<>(set));
        }
        return answer;
    }
}
