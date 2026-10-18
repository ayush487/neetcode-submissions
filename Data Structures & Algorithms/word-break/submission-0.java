class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() == 0) return true;
            int idx = s.length() - curr.length();
            if (visited[idx]) continue;
            visited[idx] = true;
            for (String word : wordDict) {
                if (curr.startsWith(word)) {
                    String ss = curr.substring(word.length());
                    queue.add(ss);
                }
            }
        }
        return false;
    }
}
