class Solution {
    private Set<List<Integer>> mainSet;
    public List<List<Integer>> permuteUnique(int[] nums) {
        mainSet = new HashSet<>();
        dfs(nums,new ArrayList<>(), new HashSet<>());
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : mainSet) list.add(l);
        return list;
    }

    private void dfs(int[] nums,List<Integer> list, Set<Integer> set) {
        if (set.size()==nums.length){
            mainSet.add(list);
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (set.contains(i)) continue;
            Set<Integer> setCopy = new HashSet<>(set);
            setCopy.add(i);
            List<Integer> listCopy = new ArrayList<>(list);
            listCopy.add(nums[i]);
            dfs(nums,listCopy, setCopy);
        }
    }
}