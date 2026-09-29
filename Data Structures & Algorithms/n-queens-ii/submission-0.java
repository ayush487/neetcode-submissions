class Solution {
    int totalQueens = 0;

    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        count(grid, n, 0);
        return totalQueens;
    }

    private void count(int[][] grid, int n, int y) {
        if (y == n) {
            totalQueens++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(grid, j, y)) {
                grid[y][j] = 1;
                count(grid, n, y + 1);
                grid[y][j] = 0;
            }
        }
    }

    private boolean isSafe(int[][] grid, int x, int y) {
        for (int i = y; i >= 0; i--) if (grid[i][x] == 1) return false;
        for (int i = y, j = x; i >= 0 && j >= 0; j--, i--) if (grid[i][j] == 1) return false;
        for (int i = y, j = x; i >= 0 && j < grid.length; i--, j++) if (grid[i][j] == 1) return false;
        return true;
    }
}