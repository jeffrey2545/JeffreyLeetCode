class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int result = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            if (maxPrice - prices[i] >= result) {
                result = maxPrice - prices[i];
            }
        }
        return result;
    }
}