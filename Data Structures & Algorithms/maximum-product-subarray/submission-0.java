class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currMax = 1, currMin = 1;
        for (int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(num, Math.max(currMax*num, currMin*num));
            currMin = Math.min(Math.min(temp, currMin*num), num);
            res = Math.max(res, currMax);
        }
        return res;
    }
}
