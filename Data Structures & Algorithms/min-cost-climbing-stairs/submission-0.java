class Solution {
    private Map<Integer, Integer> memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new HashMap<>();
        int ans1 = findMin(cost, 0);
        int ans2 = findMin(cost, 1);
        return Math.min(ans1, ans2);
    }

    private int findMin(int[] cost, int n) {
        if (n>=cost.length) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int ans = cost[n] + Math.min(findMin(cost, n+1), findMin(cost, n+2));
        memo.put(n, ans);
        return ans;
    }
}
