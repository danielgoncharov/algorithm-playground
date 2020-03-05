package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WindowString {

    public String minWindow(String string, String template) {
        HashSet<Character> templateSet = new HashSet<>();
        Map<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < template.length(); i++) templateSet.add(template.charAt(i));
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        for (int index = 0, start = 0; index < string.length(); index++) {
            Character currentCharacter = string.charAt(index);
            if (templateSet.contains(currentCharacter)) {
                int count = characters.getOrDefault(currentCharacter, 0);
                count++;
                characters.put(currentCharacter, count);
            }
            if (characters.size() != templateSet.size()) continue;
            while (characters.size() == templateSet.size()) {
                int count = characters.getOrDefault(string.charAt(start), 1);
                count--;
                if (count == 0) {
                    characters.remove(string.charAt(start));
                } else {
                    characters.put(string.charAt(start), count);
                }
                start++;
            }
            if (index - start - 1 < minEnd - minStart) {
                minStart = start - 1;
                minEnd = index;
            }

        }
        if (minEnd == Integer.MAX_VALUE) return "";
        return string.substring(minStart, minEnd + 1);
    }
}
