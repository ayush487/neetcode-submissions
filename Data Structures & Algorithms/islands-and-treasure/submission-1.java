class Solution {
    private Set<String> visited = new HashSet<>();
    private int rows;
    private int cols;
    private int[][] grid;
    private Queue<int[]> queue = new LinkedList<>();

    public void islandsAndTreasure(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited.add(i + "-" + j);
                }
            }
        int distance = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] rowcol = queue.poll();
                grid[rowcol[0]][rowcol[1]] = distance;
                visited.add(rowcol[0] + "-" + rowcol[1]);
                addQueue(rowcol[0] - 1, rowcol[1]);
                addQueue(rowcol[0] + 1, rowcol[1]);
                addQueue(rowcol[0], rowcol[1] - 1);
                addQueue(rowcol[0], rowcol[1] + 1);
            }
            distance++;
        }
    }

    private void addQueue(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == -1) return;
        if (visited.contains(i + "-" + j)) return;
        visited.add(i+"-"+j);
        queue.offer(new int[]{i, j});
    }
}
