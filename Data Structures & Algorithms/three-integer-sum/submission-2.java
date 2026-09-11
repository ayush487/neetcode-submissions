class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) break;
            if (i>0 && nums[i]==nums[i-1]) continue;

            int l = i+1;
            int r = nums.length - 1;
            int target = nums[i] * -1;
            while (l < r) {
                if (nums[l] + nums[r] > target) r--;
                else if (nums[l] + nums[r] < target) l++;
                else {
                    mainList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                    while((l < r) && (nums[l]==nums[l-1]) ) l++;
                }
            }
        }

        return mainList;
    }
}
