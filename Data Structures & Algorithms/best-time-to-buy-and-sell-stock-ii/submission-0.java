class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        int[] priceChange = new int[prices.length - 1];
        for (int i=1;i<prices.length;i++) {
            priceChange[i-1] = prices[i] - prices[i-1];
        }
        int maxProfit = 0;
        for (int change : priceChange) {
            if (change>0) maxProfit+=change;
        }
        return maxProfit;
    }
}