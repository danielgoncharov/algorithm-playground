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

        boolean result = false;
        for (int index = 0; index < A.length(); index++) {
            boolean isScrambleRec = (
                    isScrambleRec(A.substring(0, index + 1), B.substring(0, index + 1)) &&
                            isScrambleRec(A.substring(index + 1, length), B.substring(index + 1, length))
            )
                    ||
                    (
                            isScrambleRec(A.substring(0, index + 1), B.substring(length - index - 1, length)) &&
                                    isScrambleRec(A.substring(length - index - 1, length), B.substring(0, index + 1))

                    );
            result |= isScrambleRec;

        }

        return result;

    }
}
