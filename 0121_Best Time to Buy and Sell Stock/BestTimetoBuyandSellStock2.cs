public class Solution {
    public int MaxProfit (int[] prices) {
        if (prices == null || prices.Length <= 1) return 0;
        var currentMin = int.MaxValue;
        var maxProfit = int.MinValue;

        for (int i = 0; i < prices.Length; i++) {
            currentMin = Math.Min (prices[i], currentMin);
            maxProfit = Math.Max (prices[i] - currentMin, maxProfit);
        }

        return maxProfit;
    }
}