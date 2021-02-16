package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class WordBreak {

    public ArrayList<String> wordBreak(String string, ArrayList<String> dict) {
        return wordBreakRecursive(0, 0, string, dict, "", 0);
    }

    private ArrayList<String> wordBreakRecursive(
            int left,
            int right,
            String string,
            ArrayList<String> dict,
            String result,
            int resultSize
    ) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (resultSize == string.length()) {
            arrayList.add(result);
            return arrayList;
        }
        if (right >= string.length()) {
            return arrayList;
        }
        String word = string.substring(left, right + 1);
        if (dict.contains(word)) {
            result += " " + word;
            resultSize += word.length();
            arrayList.addAll(
                    wordBreakRecursive(right + 1, right + 1, string, dict, result, resultSize)
            );
        }
        arrayList.addAll(
                wordBreakRecursive(left, right + 1, string, dict, result, resultSize)
        );
        return arrayList;
    }


}
