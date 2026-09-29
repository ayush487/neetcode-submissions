class Solution {
    private List<List<String>> mainList;

    public List<List<String>> solveNQueens(int n) {
        mainList = new ArrayList<>();
        int[][] grid = new int[n][n];
        fill(grid, n, 0);
        return mainList;
    }

    private void fill(int[][] grid, int n, int y) {
        if (y==n) {
            addGrid(grid);
            return;
        };

        for (int j=0;j<n;j++) {
            if (isSafe(grid, j, y)) {
                grid[y][j] = 1;
                fill(grid, n, y+1);
                grid[y][j] = 0;
            }
        }
    }

    private void addGrid(int[][] grid) {
        List<String> list = new ArrayList<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int e : row) {
                if (e == 1) sb.append('Q');
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        mainList.add(list);
    }

    private boolean isSafe(int[][] grid, int x, int y) {
        for (int i = y; i >= 0; i--) if (grid[i][x] == 1) return false;
        for (int i = y, j = x; i >= 0 && j >= 0; i--, j--) if (grid[i][j] == 1) return false;
        for (int i = y, j = x; i >= 0 && j < grid.length; i--, j++) if (grid[i][j] == 1) return false;
        return true;
    }
}
