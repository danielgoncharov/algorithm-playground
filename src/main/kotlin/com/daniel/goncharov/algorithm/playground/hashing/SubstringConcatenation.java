package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String string, final List<String> pieces) {
        HashMap<String, Integer> piecesMap = new HashMap<>();
        for (int index = 0; index < pieces.size(); index++) {
            String piece = pieces.get(index);
            int count = piecesMap.getOrDefault(piece, 0);
            count++;
            piecesMap.put(piece, count);
        }
        int windowSize = pieces.get(0).length();
        int startIndex = 0;
        int matchCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> checkMap = new HashMap<>();
        for (int index = 0; index < string.length(); ) {
            int lastIndex = index + windowSize > string.length() ? string.length() : index + windowSize;
            String windowedString = string.substring(index, lastIndex);
            if (checkMap.isEmpty()) startIndex = index;
            int count = checkMap.getOrDefault(windowedString, 0);
            count++;
            checkMap.put(windowedString, count);
            if (piecesMap.containsKey(windowedString)
                    && checkMap.get(windowedString) <= piecesMap.get(windowedString)) {
                matchCount++;
                if (matchCount == pieces.size()) {
                    checkMap.clear();
                    result.add(startIndex);
                    matchCount = 0;
                } else {
                    index += windowSize;
                }
            } else {
                checkMap.clear();
                index++;
                matchCount = 0;
            }
        }
        return result;
    }
}
