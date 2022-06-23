package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

import java.util.ArrayList;

public class JumpGameArray {


    public int canJump(ArrayList<Integer> arrayList) {
        int lastGoodIndex = arrayList.size() - 1;
        for (int index = arrayList.size() - 1; index >= 0; index--) {
            if (index + arrayList.get(index) >= lastGoodIndex) {
                lastGoodIndex = index;
            }
        }
        return lastGoodIndex == 0 ? 1 : 0;
    }


}
