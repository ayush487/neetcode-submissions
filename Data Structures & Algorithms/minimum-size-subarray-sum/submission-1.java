class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int optimalLength = Integer.MAX_VALUE;

        int l = 0;
        int currentArrSum = nums[0];
        if (currentArrSum>=target) return 1;
        for (int r=1;r<nums.length;r++) {
            currentArrSum += nums[r];
            if (currentArrSum>=target) {
                optimalLength = Math.min(optimalLength, r - l + 1);
                while(l<r) {
                    if (currentArrSum-nums[l] >= target) {
                        l++;
                        optimalLength = Math.min(optimalLength, r - l + 1);
                        currentArrSum-=nums[l-1];
                    } else break;
                }
            }
        }

        return optimalLength==Integer.MAX_VALUE ? 0 : optimalLength;
    }
}