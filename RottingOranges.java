package coding.leetcode.problems;

import java.util.Arrays;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int depth = 0;
        boolean hasFreshOrange = false;
        // evaluate base-case

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    hasFreshOrange = true;
                }
            }
        }
        if (!hasFreshOrange) {
            return 0;
        }

        while (hasFreshOrange) {

            int[][] currentState = new int[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    currentState[i][j] = grid[i][j];
                }
            }

            System.out.println("New iteration");
            hasFreshOrange = false;
            for (int y = 0; y < grid.length; y++) {
                // System.out.println("");
                for (int x = 0; x < grid[y].length; x++) {
                    if (!this.isEmptyCell(grid, x, y) && !this.isRooted(grid[y][x])) {
                        if (grid[y][x] == 1) { // identify fresh orange
                            currentState[y][x] = this.checkDown(grid, x, y, currentState[y][x]);
                            currentState[y][x] = this.checkUp(grid, x, y, currentState[y][x]);
                            currentState[y][x] = this.checkRight(grid, x, y, currentState[y][x]);
                            currentState[y][x] = this.checkLeft(grid, x, y, currentState[y][x]);
                            if (currentState[y][x] == 1) {
                                hasFreshOrange = true;
                            }
                        }
                    }
                }
                System.out.println(Arrays.toString(currentState[y]));
            }


            if (this.isSameState(currentState, grid) && hasFreshOrange) { // current fresh orange cannot be rotted
                return -1;
            }
            grid = currentState;
            depth++;
        }

        return depth;
    }

    private boolean isSameState(int[][] currentState, int[][] newState) {
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (currentState[i][j] != newState[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isEmptyCell(int[][] grid, int x, int y) {
        return grid[y][x] == 0;
    }

    private boolean isRooted(int value) {
        return value == 2;
    }

    private int checkLeft(int[][] grid, int x, int y, int currentState) {
        int value = grid[y][x];
        if (this.isRooted(currentState)) {
            return currentState;
        }

        if (--x >= 0) {
            if (grid[y][x] == 2) {
                return 2;
            }
        }
        return value;
    }

    private int checkRight(int[][] grid, int x, int y, int currentState) {
        int value = grid[y][x];
        if (this.isRooted(currentState)) {
            return currentState;
        }

        if (++x < grid[y].length) {
            if (grid[y][x] == 2) {
                return 2;
            }
        }
        return value;
    }

    private int checkUp(int[][] grid, int x, int y, int currentState) {
        int value = grid[y][x];
        if (this.isRooted(currentState)) {
            return currentState;
        }

        if (--y >= 0) {
            if (grid[y][x] == 2) {
                return 2;
            }
        }
        return value;
    }

    private int checkDown(int[][] grid, int x, int y, int currentState) {
        int value = grid[y][x];
        if (this.isRooted(currentState)) {
            return currentState;
        }

        if (++y < grid.length) {
            if (grid[y][x] == 2) {
                return 2;
            }
        }
        return value;
    }

}
