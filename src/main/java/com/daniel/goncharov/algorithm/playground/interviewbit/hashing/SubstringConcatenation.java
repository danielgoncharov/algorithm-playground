package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

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
        int matchCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> checkMap = new HashMap<>();
        int checkSize = pieces.size() * windowSize;
        for (int j = 0; j <= string.length() - checkSize; j++) {
            String substringToCheckPermutation = string.substring(j, j + checkSize);
            for (int index = 0; index < substringToCheckPermutation.length(); index += windowSize) {
                String windowedString = substringToCheckPermutation.substring(index, index + windowSize);
                int count = checkMap.getOrDefault(windowedString, 0);
                count++;
                checkMap.put(windowedString, count);
                if (piecesMap.containsKey(windowedString)
                        && checkMap.get(windowedString) <= piecesMap.get(windowedString)) {
                    matchCount++;
                    if (matchCount == pieces.size()) {
                        checkMap.clear();
                        result.add(j);
                        matchCount = 0;
                        break;
                    }
                } else {
                    checkMap.clear();
                    matchCount = 0;
                    break;
                }
            }
        }
        return result;
    }
}
