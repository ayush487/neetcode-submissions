class Solution {
    public int rob(int[] nums) {
        int var1 = 0;
        int var2 = 0;
        int maxProfit = 0;
        for (int num : nums) {
            if (var1 > var2+num) {
                var2 = var1;
                maxProfit = var1;
            } else {
                maxProfit = var2 + num;
                int temp = var1;
                var1 = var2 + num;
                var2 = temp;
            }
        }
        return maxProfit;
    }
}
