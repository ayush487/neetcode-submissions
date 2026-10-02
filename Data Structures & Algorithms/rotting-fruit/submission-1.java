class Solution {
    private Queue<int[]> queue;
    private Set<String> visited;
    private int[][] grid;
    private int ROWS;
    private int COLS;
    private Set<String> freshFruits;

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.queue = new LinkedList<>();
        this.visited = new HashSet<>();
        this.freshFruits = new HashSet<>();
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) freshFruits.add(i + "-" + j);
                else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited.add(i + "-" + j);
                }
            }
        if (freshFruits.isEmpty()) return 0;
        int currentMin = -1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] rc = queue.poll();
                String p = rc[0] + "-" + rc[1];
                freshFruits.remove(p);
                visited.add(p);
                addFruit(rc[0] - 1, rc[1]);
                addFruit(rc[0] + 1, rc[1]);
                addFruit(rc[0], rc[1] - 1);
                addFruit(rc[0], rc[1] + 1);
            }
            currentMin++;

        }

        if (freshFruits.isEmpty()) return currentMin;
        else return -1;
    }

    private void addFruit(int i, int j) {
        if (i < 0 || i >= ROWS || j < 0 || j >= COLS) return;
        if (grid[i][j] == 0 || grid[i][j] == 2) return;
        if (visited.contains(i + "-" + j)) return;
        queue.add(new int[]{i, j});
        visited.add(i + "-" + j);
    }
}
