class Solution {
    private int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int subsetSum = sum / k;
        for (int n : nums) if (n > subsetSum) return false;
        int[] subset = new int[k];
        this.k = k;
        return dfs(nums, subset, subsetSum, 0);
    }

    private boolean dfs(int[] nums, int[] subset, int subsetSum, int index) {
        if (index == nums.length) return true;

        for (int i = 0; i < k; i++) {
            if (subset[i] + nums[index] <= subsetSum) {
                subset[i] += nums[index];
                if (dfs(nums, subset, subsetSum, index + 1)) return true;
                subset[i] -= nums[index];
            }
            if (subset[i]==0) break;
        }
        return false;
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}