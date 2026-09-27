class Solution {
    private class Sum {
        int sum;
        List<Integer> list;
        int[] arr;

        public Sum(int sum, List<Integer> list, int[] array) {
            this.sum = sum;
            this.list = list;
            this.arr = Arrays.copyOf(array, 31);
        }

        public void add(int num) {
            this.sum += num;
            this.list.add(num);
            this.arr[num]++;
        }

        public Sum copy(int newNum) {
            List<Integer> copyList = new ArrayList<>(this.list);
            copyList.add(newNum);
            int[] copyArray = Arrays.copyOf(arr, 31);
            copyArray[newNum]++;
            return new Sum(this.sum + newNum, copyList, copyArray);
        }
    }

    private List<List<Integer>> mainList;
    private List<int[]> duplicatePreventionList;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        mainList = new ArrayList<>();
        duplicatePreventionList = new ArrayList<>();
        Sum currentSum = new Sum(0, new ArrayList<Integer>(), new int[31]);
        dfs(nums, 0, currentSum, target);
        return mainList;
    }

    private void dfs(int[] nums, int startIndex, Sum currentSum, int target) {
        if (currentSum.sum > target) return;
        if (currentSum.sum == target) {
            mainList.add(currentSum.list);
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            dfs(nums, i, currentSum.copy(nums[i]), target);
        }
    }

    private boolean checkIfExist(int[] arr) {
        for (int[] array : duplicatePreventionList) {
            boolean isSame = true;
            for (int i = 0; i < 31; i++) {
                if (array[i] != arr[i]) isSame = false;
            }
            if (isSame) return true;
        }
        return false;
    }
}