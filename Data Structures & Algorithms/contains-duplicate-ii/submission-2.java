class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i=0;i<=k && i<nums.length;i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], i);
        }
        int junk = 0;
        for (int i=k+1;i<nums.length;i++) {


            map.remove(nums[junk++]);
            if (map.containsKey(nums[i])) {
                return true;
            } else map.put(nums[i], i);

        }
        return false;
    }
}