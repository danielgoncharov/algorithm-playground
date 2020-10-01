package com.daniel.goncharov.algorithm.playground.dp;

public class ScrambleString {

    public int isScramble(final String A, final String B) {
        return isScrambleRec(A, B) ? 1 : 0;
    }

    private boolean isScrambleRec(final String A, final String B) {
        if (A.length() != B.length()) return false;
        int length = A.length();
        if (length == 0) return true;
        if (length == 1) return A.charAt(0) == B.charAt(0);

        return
                (
                        isScrambleRec(A.substring(0, length / 2), B.substring(0, length / 2)) &&
                                isScrambleRec(A.substring(length / 2, length), B.substring(length / 2, length))
                )
                        ||
                        (
                                isScrambleRec(A.substring(0, length / 2), B.substring(length - length / 2, length)) &&
                                        isScrambleRec(A.substring(length - length / 2, length), B.substring(0, length / 2))

                        );
    }
}
