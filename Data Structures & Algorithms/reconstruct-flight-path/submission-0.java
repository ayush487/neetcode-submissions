class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        this.result = new ArrayList<>();
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String src) {
        PriorityQueue<String> heap = graph.get(src);
        if (heap!=null) {
            while (!heap.isEmpty()) {
                String nextPort = heap.poll();
                dfs(nextPort);
            }
        }
        result.add(src);
    }
}
