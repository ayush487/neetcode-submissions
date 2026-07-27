class Solution {
    // Hashmap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int prevCount = map.get(num);
                map.put(num, prevCount+1);
            } else map.put(num, 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key)> size/2) return key;
        }
        return 0;
    }
}