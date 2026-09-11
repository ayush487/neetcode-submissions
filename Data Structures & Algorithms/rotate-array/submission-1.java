class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotateArray(nums, 0, nums.length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, nums.length - 1);
    }

    private void rotateArray(int[] nums, int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}