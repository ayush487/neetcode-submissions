class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> list, List<Integer> currList) {
        if (idx==nums.length) {
            list.add(currList);
            return;
        }
        List<Integer> listWithThis = new ArrayList<>(currList);
        listWithThis.add(nums[idx]);
        List<Integer> listWithoutThis = new ArrayList<>(currList);
        dfs(nums, idx+1, list, listWithoutThis);
        dfs(nums, idx+1, list, listWithThis);
    }
}
