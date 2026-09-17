class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length==1 || nums[0] < nums[length - 1]) return nums[0];
        else if (length==2) return Math.min(nums[0], nums[1]);
        if (nums[length-2]>nums[length-1]) return nums[length - 1];
        int l = 0;
        int r = nums.length - 2;
        int[] res = {Integer.MAX_VALUE, nums.length};
        while (l <= r) {
            int m = l + r - l / 2;
            if (nums[m] > nums[m+1]) return res[0] > nums[m+1] ? nums[res[1]] : nums[m+1];
            if (nums[m] < res[0]) {
                res[0] = nums[m]; res[1] = m;
            }
            if (nums[m] > nums[l]) {
//                we need to proceed in right
                l = m;
            } else {
//                we need to proceed in left
                r = m-1;
            }
        }
        return nums[res[1]];
    }
}
