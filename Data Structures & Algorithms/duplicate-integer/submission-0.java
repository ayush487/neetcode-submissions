class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i==j) continue;
                if (nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
}