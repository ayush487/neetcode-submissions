class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Map<Integer, Integer> sequenceLength = new HashMap<>();
        for (int num : nums)
            if (!set.contains(num-1)) sequenceLength.put(num, 0);
        for (int seqCandidate : sequenceLength.keySet()) {
            int len = 0;
            int currentNum = seqCandidate;
            while (set.contains(currentNum)) {
                currentNum++;
                len++;
            }
            sequenceLength.put(seqCandidate, len);
        }
        int highest = 0;
        for (int i : sequenceLength.values()) {
            if (i>highest) highest = i;
        }
        return highest;
    }
}
