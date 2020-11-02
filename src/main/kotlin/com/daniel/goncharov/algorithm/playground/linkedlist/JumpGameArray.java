package com.daniel.goncharov.algorithm.playground.linkedlist;

import java.util.ArrayList;

public class JumpGameArray {

    private static final int NOT_FOUND = -1;

    public int canJump(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) return 1;
        int right = arrayList.size() - 1;
        while (right >= 0) {
            int newRight = findJumpingPoint(0, right, arrayList);
            if (newRight == NOT_FOUND) {
                return 0;
            } else if (newRight == 0) {
                return 1;
            }
            right = newRight;
        }
        return 0;
    }

    private int findJumpingPoint(int left, int right, ArrayList<Integer> arrayList) {
        for (int index = left; index < right; index++) {
            int step = arrayList.get(index);
            if (step >= right - index) return index;
        }
        return NOT_FOUND;
    }
}
