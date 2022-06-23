package com.daniel.goncharov.algorithm.playground.interviewbit.graph;

import java.util.ArrayList;

public class RegionInBinaryMatrix {

    public int solve(ArrayList<ArrayList<Integer>> regionMatrix) {
        ArrayList<ArrayList<Boolean>> visitedNodes = createVisitedMatrix(regionMatrix);

        int maxRegion = 0;
        for (int i = 0; i < regionMatrix.size(); i++) {
            ArrayList<Integer> row = regionMatrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (visitedNodes.get(i).get(j)) continue;
                maxRegion = Math.max(maxRegion, getRegionSize(i, j, regionMatrix, visitedNodes));
            }
        }
        return maxRegion;
    }

    private ArrayList<ArrayList<Boolean>> createVisitedMatrix(ArrayList<ArrayList<Integer>> regionMatrix) {
        ArrayList<ArrayList<Boolean>> visitedMatrix = new ArrayList<>();
        for (int i = 0; i < regionMatrix.size(); i++) {
            ArrayList<Integer> row = regionMatrix.get(i);
            ArrayList<Boolean> visitedRow = new ArrayList<>();
            for (int j = 0; j < row.size(); j++) {
                visitedRow.add(row.get(j) != 1);
            }
            visitedMatrix.add(visitedRow);
        }
        return visitedMatrix;
    }

    private int getRegionSize(
            int i,
            int j,
            ArrayList<ArrayList<Integer>> regionMatrix,
            ArrayList<ArrayList<Boolean>> visitedNodes
    ) {
        if (
                i < 0 ||
                        j < 0 ||
                        i == regionMatrix.size() ||
                        j == regionMatrix.get(0).size() ||
                        regionMatrix.get(i).get(j) == 0 ||
                        visitedNodes.get(i).get(j)
        ) {
            return 0;
        }
        visitedNodes.get(i).set(j, true);
        int leftTop = getRegionSize(i - 1, j - 1, regionMatrix, visitedNodes);
        int top = getRegionSize(i - 1, j, regionMatrix, visitedNodes);
        int topRight = getRegionSize(i - 1, j + 1, regionMatrix, visitedNodes);
        int right = getRegionSize(i, j + 1, regionMatrix, visitedNodes);
        int rightBottom = getRegionSize(i + 1, j + 1, regionMatrix, visitedNodes);
        int bottom = getRegionSize(i + 1, j, regionMatrix, visitedNodes);
        int leftBottom = getRegionSize(i + 1, j - 1, regionMatrix, visitedNodes);
        int left = getRegionSize(i, j - 1, regionMatrix, visitedNodes);

        return 1 + leftTop + top + topRight + right + rightBottom + bottom + leftBottom + left;
    }


}
