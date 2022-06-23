package com.daniel.goncharov.algorithm.playground.interviewbit.dp;

public class WaysToColor3xNBoard {

    public int solve(int length) {
        int[][] grid = new int[3][length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = -1;
            }
        }
        return solveRec(0, 0, grid);
    }

    private int solveRec(int i, int j, int[][] grid) {
        if (i == grid.length) return 1;
        if (j == grid[0].length) {
            i++;
            j = 0;
            return solveRec(i, j, grid);

        }
        int topColor = i - 1 >= 0 ? grid[i - 1][j] : -1;
        int colorToTheLeft = j - 1 >= 0 ? grid[i][j - 1] : -1;

        int sum = 0;
        for (int color = 0; color <= 3; color++) {
            if (color != topColor && color != colorToTheLeft) {
                grid[i][j] = color;
                sum += solveRec(i, j + 1, grid);
                grid[i][j] = -1;
            }
        }
        return sum;
    }
}
