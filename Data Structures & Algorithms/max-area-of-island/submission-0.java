class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private Map<String, Integer> islandArea;

    public int maxAreaOfIsland(int[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        this.islandArea = new HashMap<>();
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    String islandName = i + "-" + j;
                    islandArea.put(islandName, 0);
                    dfs(islandName, i, j);
                }
            }
        }
        int maxArea = 0;
        for (int area : islandArea.values()) {
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private void dfs(String island, int i, int j) {
        if ((i < 0 || i >= grid.length) || (j < 0 || j >= grid[0].length)) return;
        if (grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        islandArea.put(island, islandArea.get(island) + 1);
        dfs(island, i - 1, j);
        dfs(island, i + 1, j);
        dfs(island, i, j - 1);
        dfs(island, i, j + 1);
    }
}
