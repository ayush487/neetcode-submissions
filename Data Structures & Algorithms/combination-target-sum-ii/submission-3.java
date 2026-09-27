class Solution {
    private class Sum {
        int sum;
        List<Integer> list;

        public Sum(int sum, List<Integer> list) {
            this.sum = sum;
            this.list = list;
        }

        public Sum copy(int newNum) {
            List<Integer> copyList = new ArrayList<>(this.list);
            copyList.add(newNum);
            return new Sum(this.sum + newNum, copyList);
        }
    }

    private Set<List<Integer>> mainList;
    private List<int[]> resultInArray;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        mainList = new HashSet<>();
        Arrays.sort(candidates);
        resultInArray = new ArrayList<>();
        Sum currentSum = new Sum(0, new ArrayList<>());
        dfs(candidates, target, currentSum, 0);
        return new ArrayList<List<Integer>>(mainList);
    }

    private void dfs(int[] nums, int target, Sum currentSum, int startIdx) {
        if (currentSum.sum > target) return;
        if (currentSum.sum == target) {
            mainList.add(currentSum.list);
            return;
        }
        int prev = 0;
        for (int i = startIdx; i < nums.length; i++) {
            if (nums[i] != prev)
                dfs(nums, target, currentSum.copy(nums[i]), i + 1);
            prev = nums[i];
        }
    }
}
