class Solution {
    public int maxProfit(int[] prices) {
        int[] arr = new int[prices.length];
        int high = 0;
        arr[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            arr[i] = Math.max(prices[i], arr[i + 1]);
        }
        for (int i = 0; i < prices.length; i++) {
            high = Math.max(high, arr[i] - prices[i]);
        }
        return high;
    }
}
