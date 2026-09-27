class Solution {
    private List<List<Integer>> mainList;
    public List<List<Integer>> permute(int[] nums) {
        mainList = new ArrayList<>();
        dfs(nums,new ArrayList<>(), new HashSet<>());
        return mainList;
    }


    private void dfs(int[] nums,List<Integer> list, Set<Integer> set) {
        if (set.size()==nums.length){
            mainList.add(list);
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) continue;
            Set<Integer> setCopy = new HashSet<>(set);
            setCopy.add(nums[i]);
            List<Integer> listCopy = new ArrayList<>(list);
            listCopy.add(nums[i]);
            dfs(nums,listCopy, setCopy);
        }
    }
}
