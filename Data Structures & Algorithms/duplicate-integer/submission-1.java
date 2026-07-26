class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            if (set.contains(e)) return true;
            else set.add(e);
        }
        return false;
    }
}