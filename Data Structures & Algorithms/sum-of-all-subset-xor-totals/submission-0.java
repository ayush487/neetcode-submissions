class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0, nums, 0);
    }

    private int dfs(int idx, int[] nums, int total) {
        if (idx==nums.length) return total;
        return dfs(idx + 1, nums, total) + dfs(idx + 1, nums, total ^ nums[idx]);
    }
}