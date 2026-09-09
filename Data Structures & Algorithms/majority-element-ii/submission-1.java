class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Map<Integer, Integer> majorityElementMap = new HashMap<>();
        for (int num : nums) {
            if (majorityElementMap.containsKey(num)) {
                int prevCount = majorityElementMap.get(num);
                majorityElementMap.put(num, prevCount + 1);
            } else {
                if (majorityElementMap.size() < 2) {
                    majorityElementMap.put(num, 1);
                } else {
                    Set<Integer> majorityElementSet = new HashSet<>(majorityElementMap.keySet());
                    for (int prevEle : majorityElementSet) {
                        int prevEleCount = majorityElementMap.get(prevEle);
                        if (prevEleCount <= 1) {
                            majorityElementMap.remove(prevEle);
                        } else
                            majorityElementMap.put(prevEle, prevEleCount - 1);
                    }
                }

            }
        }
        List<Integer> majorElementList = new ArrayList<>();
        System.out.println(majorityElementMap.keySet());
        for (int majorityElementCandidate : majorityElementMap.keySet()) {
            if (isMajorityElement(nums, majorityElementCandidate)) majorElementList.add(majorityElementCandidate);
        }
        return majorElementList;
    }

    private boolean isMajorityElement(int[] nums, int num) {
        int majorityCount = (nums.length / 3) + 1;
        int eleCount = 0;
        for (int n : nums) if (n == num) eleCount++;
        if (eleCount >= majorityCount) return true;
        return false;
    }
}