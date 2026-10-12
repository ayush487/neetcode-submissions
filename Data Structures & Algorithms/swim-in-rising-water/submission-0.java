class Solution {
    public int swimInWater(int[][] grid) {
        if (grid.length==1) return 0;
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[2], p2[2]));
        boolean[][] isAdded = new boolean[grid.length][grid.length];
        int min = grid[0][0];
        pq.add(new int[]{0,0, grid[0][0]});
        isAdded[0][0] = true;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            min = Math.max(min, current[2]);
            if (current[0]==n-1 && current[1]==n-1) {
                return min;
            }
            List<int[]> neighbours = getNeighbours(current, grid, isAdded);
            for (int[] neigh : neighbours) {
                pq.offer(neigh);
                isAdded[neigh[1]][neigh[0]] = true;
            }
        }
        return min;
    }

    private List<int[]> getNeighbours(int[] current,int[][] grid, boolean[][] isAdded) {
        List<int[]> list = new ArrayList<>();
        int n = grid.length;
        if (current[0]>0 && !isAdded[current[1]][current[0]-1]) {
            list.add(new int[]{current[0]-1, current[1], grid[current[1]][current[0]-1]});
        }
        if (current[0]<n-1 && !isAdded[current[1]][current[0]+1]) {
            list.add(new int[]{current[0]+1, current[1], grid[current[1]][current[0]+1]});
        }
        if (current[1]>0 && !isAdded[current[1]-1][current[0]]) {
            list.add(new int[]{current[0], current[1]-1, grid[current[1]-1][current[0]]});
        }
        if (current[1]<n-1 && !isAdded[current[1]+1][current[0]]) {
            list.add(new int[]{current[0], current[1]+1, grid[current[1]+1][current[0]]});
        }
        return list;
    }
}
