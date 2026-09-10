class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        int currentPrefixSum = 0;
        int result = 0;
        for (int num : nums) {
            currentPrefixSum+=num;
            int req = currentPrefixSum - k;
            result += prefixSumCount.getOrDefault(req, 0);
            int currentPrefixSumCount = prefixSumCount.getOrDefault(currentPrefixSum, 0);
            prefixSumCount.put(currentPrefixSum, currentPrefixSumCount+1);
        }
        return result;
    }
}