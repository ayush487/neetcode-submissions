class Solution {
    private class Box {
        int i, j, height;

        public Box(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }

    private class Path {
        Box from;
        Box to;
        int effort;

        public Path(Box from, Box to, int effort) {
            this.from = from;
            this.to = to;
            this.effort = effort;
        }
    }

    private int rows;
    private int cols;
    private Box[][] boxes;

    public int minimumEffortPath(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;

        if (rows == 1 && cols == 1) return 0;
        else if (rows == 1) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < cols; j++) max = Math.max(max, Math.abs(heights[0][j] - heights[0][j - 1]));
            return max;
        } else if (cols == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < rows; i++) max = Math.max(max, Math.abs(heights[i][0] - heights[i - 1][0]));
            return max;
        }

        this.boxes = new Box[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                boxes[i][j] = new Box(i, j, heights[i][j]);

        Box targetBox = boxes[rows - 1][cols - 1];

        PriorityQueue<Path> minHeap = new PriorityQueue<>((p1, p2) -> p1.effort - p2.effort);
        Box initialBox = boxes[0][0];
        for (Box neigh : getNeighbours(initialBox)) {
            Path p = new Path(initialBox, neigh, Math.abs(neigh.height - initialBox.height));
            minHeap.offer(p);
        }
        Set<Box> visited = new HashSet<>();
        visited.add(initialBox);

        while (!minHeap.isEmpty()) {
            Path currBestPath = minHeap.poll();
            Box currentBox = currBestPath.to;
            if (currentBox==targetBox) {
                return currBestPath.effort;
            }
            visited.add(currentBox);
            int prevEffort = currBestPath.effort;
            for (Box neigh : getNeighbours(currentBox)) {
                if (visited.contains(neigh)) continue;
                int effortForThis = Math.max(prevEffort, Math.abs(currentBox.height - neigh.height));
                Path path = new Path(currentBox, neigh, effortForThis);
                minHeap.offer(path);
            }
        }

        return 0;

    }

    private List<Box> getNeighbours(Box b) {
        List<Box> neighbours = new ArrayList<>();
        int currI = b.i;
        int currJ = b.j;
        if (currI - 1 >= 0) neighbours.add(boxes[currI - 1][currJ]);
        if (currI + 1 < rows) neighbours.add(boxes[currI + 1][currJ]);
        if (currJ - 1 >= 0) neighbours.add(boxes[currI][currJ - 1]);
        if (currJ + 1 < cols) neighbours.add(boxes[currI][currJ + 1]);
        return neighbours;
    }
}