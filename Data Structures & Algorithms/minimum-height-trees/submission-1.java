class Solution {
    private Map<Integer, List<Integer>> tree;
    private Map<Integer, Integer> heights;
    int currentMinimumHeight = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1) return List.of(0);
        this.tree = new HashMap<>();
        this.heights = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        for (int i=0;i<n;i++) {
            int treeHeight = height(i, -1, 0);
            currentMinimumHeight = Math.min(currentMinimumHeight, treeHeight);
            heights.put(i, treeHeight);
        }
        List<Integer> ans = new ArrayList<>();
        for (int node : heights.keySet()) {
            if (heights.get(node)==currentMinimumHeight) ans.add(node);
        }
        return ans;
    }

    private int height(int n,int parent, int currHeight) {
        List<Integer> edges = tree.get(n);
        if (edges.size()==1 && edges.get(0)==parent) return currHeight;
        int nn = 0;
        for (int e : edges) {
            if (e==parent) continue;
            int h = height(e, n, currHeight+1);
            nn = Math.max(nn, h);
        }
        return nn;
    }
}