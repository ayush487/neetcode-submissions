class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) connections.add(new ArrayList<>());

        int[] degrees = new int[n];
        for (int[] edge : edges) {
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        Queue<Integer> leafNodes = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (degrees[i] == 1) {
                leafNodes.add(i);
            }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leafNodeCount = leafNodes.size();
            remainingNodes -= leafNodeCount;
            
            for (int i = 0; i < leafNodeCount; i++) {
                int leafNode = leafNodes.poll();
                degrees[leafNode]--;
                List<Integer> leafNeighbours = connections.get(leafNode);
                for (int neigh : leafNeighbours) {
                    degrees[neigh]--;
                    if (degrees[neigh] == 1) leafNodes.add(neigh);
                }
            }
        }
        return new ArrayList<>(leafNodes);
    }
}