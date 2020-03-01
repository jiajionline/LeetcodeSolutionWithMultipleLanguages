public class Solution {
    public int MaxProfit (int[] prices) {
        if (prices == null || prices.Length <= 1) return 0;
        int maxProfit = 0;
        int currentMin = prices[0];
        for (int i = 1; i < prices.Length; i++) {
            maxProfit = Math.Max (maxProfit, prices[i] - currentMin);
            currentMin = Math.Min (currentMin, prices[i]);
        }

        return maxProfit;
    }
}