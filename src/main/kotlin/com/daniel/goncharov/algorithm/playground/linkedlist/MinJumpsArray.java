package com.daniel.goncharov.algorithm.playground.linkedlist;

import java.util.ArrayList;

public class MinJumpsArray {

    private static final int NOT_FOUND = -1;

    public int jump(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) return 0;
        int right = arrayList.size() - 1;
        int i = 0;
        while (right >= 0) {
            int newRight = findJumpingPoint(0, right, arrayList);
            i++;
            if (newRight == NOT_FOUND) {
                return -1;
            } else if (newRight == 0) {
                return i;
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
