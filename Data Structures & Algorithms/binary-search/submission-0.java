class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums,int target, int i, int j) {
        if (i>j) return -1;
        int mid = (i+j) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearch(nums, target, i, mid - 1);
        else return binarySearch(nums, target, mid + 1, j);
    }
}
