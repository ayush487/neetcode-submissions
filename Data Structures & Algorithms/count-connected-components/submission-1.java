class Solution {
    private Map<Integer, List<Integer>> edgeMap;
    private Set<Integer> notVisited;

    public int countComponents(int n, int[][] edges) {
        this.edgeMap = new HashMap<>();
        this.notVisited = new HashSet<>();
        for (int i = 0; i < n; i++) notVisited.add(i);
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }

        int count = 0;
        while (notVisited.size() != 0) {
            count++;
            int currentNode = notVisited.stream().findFirst().get();
            if (!edgeMap.containsKey(currentNode)) {
                notVisited.remove(currentNode);
                continue;
            }
            Set<Integer> parents = new HashSet<>();
            parents.add(currentNode);

            dfs(parents, -1, currentNode);
        }
        return count;
    }

    private void dfs(Set<Integer> parents, int currentParent, int currentNode) {
        this.notVisited.remove(currentNode);
        if (edgeMap.get(currentNode).size() == 1 && edgeMap.get(currentNode).get(0) == currentParent) return;

        for (int edge : edgeMap.get(currentNode)) {
            notVisited.remove(edge);
            if (edge == currentParent) continue;
            if (parents.contains(edge)) continue;
            parents.add(edge);
            dfs(parents, currentNode, edge);
        }
    }
}
