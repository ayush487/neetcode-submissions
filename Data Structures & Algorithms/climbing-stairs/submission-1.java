class Solution {
    private Map<Integer, Integer> memo;
    public int climbStairs(int n) {
        memo = new HashMap<>();
        return solve(0, n);
    }

    private int solve(int curr, int n) {
        if (curr>n) return 0;
        if (curr==n) return 1;

        if (memo.containsKey(curr)) return memo.get(curr);
        int add = 0;
        add += solve(curr+1, n);
        add += solve(curr+2, n);
        memo.put(curr, add);
        return add;
    }
}
