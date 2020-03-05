package com.daniel.goncharov.algorithm.playground.hashing;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String string) {
        int length = 0;
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                Character currentCharacter = string.charAt(j);
                if (characters.contains(currentCharacter)) {
                    break;
                } else {
                    characters.add(currentCharacter);
                }

            }
            if (characters.size() > length) {
                length = characters.size();
            }
            characters.clear();
        }
        return length;
    }
}
