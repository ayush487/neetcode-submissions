class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(0);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int curr = queue.poll();
                for (int coin : coins) {
                    if (curr+coin==amount) return level;
                    if (curr+coin > amount || visited[curr+coin]) continue;
                    visited[curr+coin] = true;
                    queue.offer(curr+coin);
                }
            }
        }

        return -1;
    }
}
