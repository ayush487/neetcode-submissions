class Solution {
    public int firstMissingPositive(int[] nums) {
        final int length = nums.length;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 1 || nums[i] > length) nums[i] = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (n < 1 || n > length) continue;
            if (nums[n-1] == 0) nums[n-1] = (length + 1) * -1;
            else nums[n-1] = Math.abs(nums[n-1]) * -1;
        }
        for (int i=0;i<length;i++) {
            if (nums[i]>=0) return i+1;
        }
        return length + 1;
    }
}