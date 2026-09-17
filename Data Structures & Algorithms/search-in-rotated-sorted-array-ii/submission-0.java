class Solution {
    

    public boolean search(int[] nums, int target) {
        final int start = findActualStart(nums);
        final int length = nums.length;
        int idx =  Math.max(binarySearch(nums, target, 0, start-1), binarySearch(nums, target, start, length - 1));
        return idx== -1 ? false : true;
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int m = l + (r-l) / 2;
        if (nums[m] == target) return m;
        else if (nums[m] > target) return binarySearch(nums, target, l, m-1); // r = m-1
        else return binarySearch(nums, target, m+1, r);
    }

    private int findActualStart(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] < nums[length - 1]) return 0;
        else if (length == 2) return nums[0] < nums[1] ? 0 : 1;
        if (nums[length - 2] > nums[length - 1]) return length - 1;
        int l = 0;
        int r = nums.length - 2;
        int[] res = {Integer.MAX_VALUE, nums.length};
        while (l <= r) {
            int m = l + r - l / 2;
            if (nums[m] > nums[m + 1]) return res[0] > nums[m + 1] ? res[1] : m + 1;
            if (nums[m] < res[0]) {
                res[0] = nums[m];
                res[1] = m;
            }
            if (nums[m] > nums[l]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return res[1];
    }
}