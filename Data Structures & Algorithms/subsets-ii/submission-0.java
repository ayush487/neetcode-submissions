class Solution {
    private List<List<Integer>> mainList;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        mainList = new ArrayList<>();
        List<Integer> blankList = new ArrayList<>();
        mainList.add(blankList);
        Arrays.sort(nums);
        dfs(nums, blankList, 0);
        return mainList;
    }

    private void dfs(int[] nums, List<Integer> currentList, int startIdx) {
        if (startIdx>=nums.length) return;
        int prev = -30;
        for (int i=startIdx;i<nums.length;i++) {
            if (prev==nums[i]) continue;
            prev = nums[i];
            List<Integer> newList = new ArrayList<>(currentList);
            newList.add(nums[i]);
            mainList.add(newList);
            dfs(nums, newList, i+1);
        }
    }
}
