package com.daniel.goncharov.algorithm.playground.interviewbit.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    //gredy
    public ArrayList<String> fullJustify(ArrayList<String> words, int maxLength) {
        ArrayList<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        for (int index = 0; index < words.size(); index++) {
            String word = words.get(index).trim();
            if (takesTheWholeLine(word, maxLength)) {
                result.add(leftAlign(word, maxLength));
                continue;
            }
            if (length + line.size() + word.length() > maxLength) {
                result.add(justify(line, maxLength, length));
                line.clear();
                length = 0;
            }
            line.add(word);
            length += word.length();
            if (index == words.size() - 1) {
                String string = buildString(line);
                result.add(leftAlign(string, maxLength));
            }
        }
        return result;
    }

    private String buildString(List<String> line) {
        String result = "";
        for (int index = 0; index < line.size(); index++) {
            String word = line.get(index);
            result += word;
            if (index != line.size() - 1) {
                result += " ";
            }
        }
        return result;
    }

    private boolean takesTheWholeLine(String word, int maxLength) {
        return word.length() + 1 >= maxLength;
    }

    private String leftAlign(String word, int maxLength) {
        int index = word.length();
        while (index < maxLength) {
            word += " ";
            index++;
        }
        return word;
    }

    private String justify(List<String> line, int maxLength, int length) {
        if (line.size() == 1) {
            return leftAlign(line.get(0), maxLength);
        }
        int tabsBetweenWords = (maxLength - length) / (line.size() - 1);
        int remainingTabs = (maxLength - length) % (line.size()-1);
        String tabs = String.join("", Collections.nCopies(tabsBetweenWords, " "));
        String result = "";
        for (int index = 0; index < line.size(); index++) {
            String word = line.get(index);
            result += word;
            if (index != line.size() - 1) {
                result += tabs;
            }
            if (remainingTabs != 0) {
                result += " ";
                remainingTabs--;
            }
        }
        return result;
    }
}
