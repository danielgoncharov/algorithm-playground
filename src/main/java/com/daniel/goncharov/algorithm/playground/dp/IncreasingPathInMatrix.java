package com.daniel.goncharov.algorithm.playground.dp;

import java.util.ArrayList;

public class IncreasingPathInMatrix {
    private static final int NO_PATH = -1;

    public int solve(ArrayList<ArrayList<Integer>> weightsMatrix) {
        ArrayList<ArrayList<Integer>> pathMatrix = new ArrayList<>();
        for (int i = 0; i < weightsMatrix.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            pathMatrix.add(row);
            for (int j = 0; j < weightsMatrix.get(i).size(); j++) {
                if (i == 0 && j == 0) {
                    row.add(1);
                } else {
                    row.add(NO_PATH);
                }
            }
        }


        int maxPath = 1;
        for (int i = 0; i < weightsMatrix.size(); i++) {
            ArrayList<Integer> row = weightsMatrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                int pathToItem = getLongestPathValue(weightsMatrix, i, j, pathMatrix);
                maxPath = Math.max(maxPath, pathToItem);
            }
        }
        ArrayList<Integer> lastRow = pathMatrix.get(pathMatrix.size() - 1);
        return lastRow.get(lastRow.size() - 1);
    }

    private int getLongestPathValue(ArrayList<ArrayList<Integer>> weightsMatrix, int i, int j, ArrayList<ArrayList<Integer>> pathMatrix) {
        int fromTop = getFromTop(weightsMatrix, i, j, pathMatrix);
        int fromLeft = getFromLeft(weightsMatrix, i, j, pathMatrix);
        if (fromLeft == NO_PATH && fromTop == NO_PATH) return 1;
        int longestPathSoFar = Math.max(fromLeft, fromTop) + 1;
        pathMatrix.get(i).set(j, longestPathSoFar);
        return longestPathSoFar;
    }

    private int getFromTop(ArrayList<ArrayList<Integer>> weightsMatrix, int i, int j, ArrayList<ArrayList<Integer>> pathMatrix) {
        int fromTopIndex = i - 1;
        if (fromTopIndex < 0) return NO_PATH;
        if (weightsMatrix.get(i).get(j) <= weightsMatrix.get(fromTopIndex).get(j)) return NO_PATH;
        int fromTopPathLength = pathMatrix.get(fromTopIndex).get(j);
        if (fromTopPathLength == NO_PATH) return NO_PATH;
        return fromTopPathLength;
    }

    private int getFromLeft(ArrayList<ArrayList<Integer>> weightsMatrix, int i, int j, ArrayList<ArrayList<Integer>> pathMatrix) {
        int fromLeftIndex = j - 1;
        if (fromLeftIndex < 0) return NO_PATH;
        if (weightsMatrix.get(i).get(j) <= weightsMatrix.get(i).get(fromLeftIndex)) return NO_PATH;
        int fromLeftPathLength = pathMatrix.get(i).get(fromLeftIndex);
        if (fromLeftPathLength == NO_PATH) return NO_PATH;
        return fromLeftPathLength;
    }
}
