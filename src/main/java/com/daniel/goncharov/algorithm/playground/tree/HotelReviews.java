package com.daniel.goncharov.algorithm.playground.tree;

import java.util.*;

public class HotelReviews {

    public ArrayList<Integer> solve(String goodWords, ArrayList<String> reviews) {
        if (goodWords.length() == 0 || reviews.size() == 0) return new ArrayList<>();
        HashSet<String> goodWordsSet = new HashSet<>();
        for (String goodWord : goodWords.split("_")) goodWordsSet.add(goodWord);

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (int index = 0; index < reviews.size(); index++) {
            String review = reviews.get(index);
            int count = 0;
            for (String reviewWord : review.split("_")) {
                if (goodWordsSet.contains(reviewWord)) {
                    count++;
                }
            }
            ArrayList<Integer> indexes = map.getOrDefault(count, new ArrayList<>());
            indexes.add(index);
            map.put(count, indexes);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;

    }
}
