package com.daniel.goncharov.algorithm.playground.dp;

public class ScrambleString {

    public int isScramble(final String A, final String B) {
        if (A.length() != B.length()) return 0;
        return isScrambleRec(A, B, 0, 0, A.length()) ? 1 : 0;
    }

    private boolean isScrambleRec(
            String A,
            String B,
            int startA,
            int startB,
            int length
    ) {
        if (length == 0) return true;
        if (length == 1) return A.charAt(startA) == B.charAt(startB);


        for (int index = startA; index < A.length(); index++) {


            if ((
                    isScrambleRec(
                            A,
                            B,
                            startA,
                            startB,
                            index + 1
                    ) &&
                            isScrambleRec(
                                    A,
                                    B,
                                    index + 1,
                                    index + 1,
                                    length - index
                            )
            )
                    ||
                    (
                            isScrambleRec(
                                    A,
                                    B,
                                    startA,
                                    length - index - 1,
                                    index + 1
                            ) &&
                                    isScrambleRec(
                                            A,
                                            B,
                                            length - index - 1,
                                            startB,
                                            index + 1
                                    )

                    )) return true;

        }

        return false;

    }
}
