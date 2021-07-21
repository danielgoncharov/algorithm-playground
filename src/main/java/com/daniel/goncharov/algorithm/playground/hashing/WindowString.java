package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public String minWindow(String string, String template) {
        if (template.length() > string.length()) return "";
        HashMap<Character, Integer> templateMap = new HashMap<>();
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int index = 0; index < template.length(); index++) {
            Character currentCharacter = template.charAt(index);
            int count = templateMap.getOrDefault(currentCharacter, 0);
            count++;
            templateMap.put(currentCharacter, count);
        }
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        int matchedCharacters = 0;
        for (int index = 0, start = 0; index < string.length(); index++) {
            Character currentCharacter = string.charAt(index);
            int count = charactersMap.getOrDefault(currentCharacter, 0);
            count++;
            charactersMap.put(currentCharacter, count);
            if (templateMap.containsKey(currentCharacter)
                    && charactersMap.get(currentCharacter) <= templateMap.get(currentCharacter)) {
                matchedCharacters++;
            }
            if (template.length() != matchedCharacters) continue;
            while (charactersMap.getOrDefault(string.charAt(start), 0) > templateMap.getOrDefault(string.charAt(start), 0)
                    || !templateMap.containsKey(string.charAt(start))) {
                if (charactersMap.getOrDefault(string.charAt(start), 0) > templateMap.getOrDefault(string.charAt(start), 0)) {
                    int matchCount = charactersMap.getOrDefault(string.charAt(start), 0);
                    if (matchCount == 0) charactersMap.remove(string.charAt(start));
                    matchCount--;
                    charactersMap.put(string.charAt(start), matchCount);
                }
                start++;
            }
            if (index - start < minEnd - minStart) {
                minStart = start;
                minEnd = index;
            }

        }
        if (minEnd == Integer.MAX_VALUE) return "";
        return string.substring(minStart, minEnd + 1);
    }
}
