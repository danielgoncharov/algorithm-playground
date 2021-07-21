package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBreak {

    public ArrayList<String> wordBreak(String string, ArrayList<String> dict) {
        return wordBreakRecursive(0, string, dict, new HashMap<>());
    }

    private ArrayList<String> wordBreakRecursive(
            int index,
            String string,
            ArrayList<String> dict,
            Map<Integer, ArrayList<String>> map
    ) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (index == string.length()) {
            return arrayList;
        }
        for (int i = index; i < string.length(); i++) {
            String word = string.substring(index, i + 1);
            if (!dict.contains(word)) continue;
            if (i == string.length() - 1) {
                arrayList.add(word);
                return arrayList;
            }
            ArrayList<String> results = wordBreakRecursive(i + 1, string, dict, map);
            for (String result : results) {
                arrayList.add(word + " " + result);
            }
            map.put(index, arrayList);


        }

        return arrayList;
    }


}
