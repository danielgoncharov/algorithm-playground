package com.daniel.goncharov.algorithm.playground.interviewbit.hashing;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String string) {
        int length = 0;
        HashSet<Character> characters = new HashSet<>();
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            Character currentCharacter = string.charAt(i);
            while (characters.contains(currentCharacter)) {
                characters.remove(string.charAt(start));
                start++;
            }
            characters.add(currentCharacter);
            length = Math.max(length, characters.size());
        }
        return length;
    }
}
