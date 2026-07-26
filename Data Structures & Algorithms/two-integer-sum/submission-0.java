class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i=0;i<n;i++) {
            map.put(nums[i], i);
        }
        for (int i=0;i<n;i++) {
            int subTarget = target - nums[i];
            if (map.containsKey(subTarget) && map.get(subTarget)!=i) {
                int[] ans = new int[2];
                ans[0] = i;
                ans[1] = map.get(subTarget);
                return ans;
            }
        }
        return new int[2];
    }
}
