class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer1 = 0;
        int pointer2 = 0;
        int k = 0;
        for (; pointer2 < nums.length; pointer2++) {
            if (nums[pointer2] != val) {
                k++;
                if (pointer1 != pointer2) {
                    nums[pointer1] = nums[pointer2];
                }
                pointer1++;
            }
        }
        return k;
    }
}