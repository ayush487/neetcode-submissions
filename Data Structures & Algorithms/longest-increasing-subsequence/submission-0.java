class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] ansArray = new int[nums.length];
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currLongest = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    currLongest = Math.max(currLongest, ansArray[j]);
            }
            ansArray[i] = currLongest + 1;
            ans = Math.max(ans, ansArray[i]);
        }
        return ans;
    }
}
