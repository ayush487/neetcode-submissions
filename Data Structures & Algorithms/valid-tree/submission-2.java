class Solution {
    private Map<Integer, List<Integer>> edgeMap;
    private Set<Integer> notVisited;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length==0) {
            if (n==1) return true;
            else return false;
        }
        this.edgeMap = new HashMap<>();
        this.notVisited = new HashSet<>();
        for (int i = 0; i < n; i++) notVisited.add(i);
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();
        notVisited.remove(0);
        boolean isCycle = isCycle(set, -1, 0);
        if (isCycle) return false;
        if (notVisited.size()!=0) return false;
        return true;

    }

    private boolean isCycle(Set<Integer> parents, int currentParent, int currentNode) {
        if (edgeMap.get(currentNode).size() == 1 && currentNode!=0) return false;
        for (int edge : edgeMap.get(currentNode)) {
            notVisited.remove(edge);
            if (edge == currentParent) continue;
            if (parents.contains(edge)) return true;
            parents.add(edge);
            if (isCycle(parents, currentNode, edge)) return true;
            parents.remove(edge);
        }
        return false;
    }
}
