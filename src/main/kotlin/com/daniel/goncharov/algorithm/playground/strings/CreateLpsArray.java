package com.daniel.goncharov.algorithm.playground.strings;

public class CreateLpsArray {

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
}
