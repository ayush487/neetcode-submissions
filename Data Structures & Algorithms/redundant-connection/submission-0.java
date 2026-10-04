class Solution {
    private Map<Integer, List<Integer>> edgeMap;
    public int[] findRedundantConnection(int[][] edges) {
        this.edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            if (canGo(edge[0], edge[1], -1)) return edge;
            edgeMap.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        return new int[]{1,2};
    }

    private boolean canGo(int from, int to, int fromParent) {
        if (!edgeMap.containsKey(from)) return false;
        for (int edge : edgeMap.get(from)) {
            if (edge==to) return true;
            if (edge==fromParent) continue;
            if (canGo(edge, to, from)) return true;
        }
        return false;
    }
}
