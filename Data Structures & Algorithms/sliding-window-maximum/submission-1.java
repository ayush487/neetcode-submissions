class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a,b) -> a<b ? 1 : -1);

        int[] result = new int[nums.length - k + 1];
        for (int i=0;i<k;i++) {
            if (i==0) pQ.offer(nums[i]);
            else {
                int currentTop = pQ.peek();
                if (currentTop>=nums[i]) {
                    pQ.offer(nums[i]);
                } else {
                    pQ.clear();
                    pQ.add(nums[i]);
                }
            }
        }
        result[0] = pQ.peek();
        for (int i=k;i<nums.length;i++) {
            if (pQ.peek()==nums[i-k]) pQ.poll();
            int currentTop = pQ.isEmpty() ? Integer.MIN_VALUE : pQ.peek();
            if (currentTop>=nums[i]) {
                pQ.offer(nums[i]);
            } else {
                pQ.clear();
                pQ.add(nums[i]);
            }
            result[i-k+1] = pQ.peek();
        }
        return result;
    }
}
