class Solution {
    public int findDuplicate(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==i+1) continue;
            if (nums[nums[i]-1]==nums[i]) return nums[i];
            else {
                swap(nums, i, nums[i]-1);
                i--;
            }
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
