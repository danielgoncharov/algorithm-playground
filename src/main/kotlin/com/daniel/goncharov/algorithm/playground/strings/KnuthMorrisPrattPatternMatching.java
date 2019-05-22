package com.daniel.goncharov.algorithm.playground.strings;

public class KnuthMorrisPrattPatternMatching {

    public int[] createLpsArray(String pattern) {
        int[] lpsArray = new int[pattern.length()];
        lpsArray[0] = 0;
        int left = 0;
        int right = 1;
        while (right < lpsArray.length) {
            char leftChar = pattern.charAt(left);
            char rightChar = pattern.charAt(right);

            if (leftChar == rightChar) {
                lpsArray[right] = left + 1;
                right++;
                left++;
                continue;
            }

            if (left == 0) {
                lpsArray[right] = 0;
                right++;
                continue;
            }

            left = lpsArray[left - 1];
        }
        return lpsArray;
    }

    public int findSubstring(final String haystack, final String needle) {
        if (haystack.length() < needle.length()) return -1;
        int[] lpsArray = createLpsArray(needle);
        int needleIndex = 0;
        int haystackIndex = 0;
        while (haystackIndex < haystack.length() && needleIndex < needle.length()) {
            char needleChar = needle.charAt(needleIndex);
            char haystackChar = haystack.charAt(haystackIndex);
            if (needleChar == haystackChar) {
                needleIndex++;
                haystackIndex++;
                continue;
            }
            if (needleIndex > 0) {
                needleIndex = lpsArray[needleIndex - 1];
            } else {
                haystackIndex++;
            }
        }
        if (needleIndex == needle.length()) {
            return haystackIndex - needleIndex;
        } else {
            return -1;
        }
    }
}
