class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) perimeter += getBorderSides(grid, i, j);
            }
        return perimeter;
    }

    private int getBorderSides(int[][] grid, int i, int j) {
        int side = 0;
        if (getVal(grid, i - 1, j) == 0) side++;
        if (getVal(grid, i + 1, j) == 0) side++;
        if (getVal(grid, i, j - 1) == 0) side++;
        if (getVal(grid, i, j + 1) == 0) side++;
        return side;
    }

    private int getVal(int[][] grid, int i, int j) {
        try {
            int val = grid[i][j];
            return val;
        } catch (RuntimeException e) {
            return 0;
        }
    }
}