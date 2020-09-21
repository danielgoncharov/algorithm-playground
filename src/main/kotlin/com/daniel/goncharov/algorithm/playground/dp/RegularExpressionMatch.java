package com.daniel.goncharov.algorithm.playground.dp;

public class RegularExpressionMatch {

    public int isMatch(final String A, final String B) {
        return isMatchRecursive(A, trim(B)) ? 1 : 0;
    }

    private String trim(String B) {
        StringBuilder stringBuilder = new StringBuilder();
        Character previousCharacter = null;
        for (Character character : B.toCharArray()) {
            if (previousCharacter == null || character.charValue() != previousCharacter.charValue() || previousCharacter.charValue() != '*') {
                stringBuilder.append(character);
            }
            previousCharacter = character;
        }
        return stringBuilder.toString();
    }

    private boolean isMatchRecursive(final String A, final String B) {
        if (A.isEmpty() && B.length() > 1) return false;

        if (
                (A.isEmpty() && B.isEmpty()) ||
                        (A.isEmpty() && B.length() == 1 && B.charAt(0) == '*')
        ) return true;

        if (A.charAt(0) == B.charAt(0) || B.charAt(0) == '?') {
            return isMatchRecursive(A.substring(1), B.substring(1));
        } else if (B.charAt(0) == '*') {
            return isMatchRecursive(A.substring(1), B) || isMatchRecursive(A.substring(1), B.substring(1));
        } else {
            return false;
        }
    }
    //todo trim consecutive **
}
