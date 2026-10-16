class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];

        int var1 = 0;
        int var2 = 0;
        for (int i=0;i<nums.length-1;i++) {
            if (var1 > var2 + nums[i]) {
                var2 = var1;
            } else {
                int temp = var1;
                var1 = var2 + nums[i];
                var2 = temp;
            }
        }
        int profitSkippingLast = var1;

        var1 = 0;
        var2 = 0;
        for (int i=1;i<nums.length;i++) {
            if (var1 > var2 + nums[i]) {
                var2 = var1;
            } else {
                int temp = var1;
                var1 = var2 + nums[i];
                var2 = temp;
            }
        }
        return Math.max(var1, profitSkippingLast);

    }
}
