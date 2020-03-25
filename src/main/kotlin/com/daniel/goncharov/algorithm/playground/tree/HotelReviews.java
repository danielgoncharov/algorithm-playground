package com.daniel.goncharov.algorithm.playground.tree;

import java.util.*;

public class HotelReviews {

    public ArrayList<Integer> solve(String goodWords, ArrayList<String> reviews) {
        String[] goodWordsArray = goodWords.split("_");
        HashSet<String> goodWordsSet = new HashSet<>();
        for (String goodWord : goodWordsArray) {
            goodWordsSet.add(goodWord);
        }

        HashSet<String> reviewWords = new HashSet<>();
        HashMap<Integer, Integer> sortedOrder = new HashMap<>();
        for (int index = 0; index < reviews.size(); index++) {
            String currentReview = reviews.get(index);
            String[] words = currentReview.split("_");
            for (String word : words) {
                if (goodWordsSet.contains(word)) {
                    reviewWords.add(word);
                }
            }
            sortedOrder.put(index, reviewWords.size());
            reviewWords.clear();
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(sortedOrder.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        ArrayList<Integer> result=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:entries){
            result.add(entry.getKey());
        }
        return result;
    }
}
