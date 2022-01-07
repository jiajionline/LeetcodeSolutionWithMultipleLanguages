class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int currMin = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++) {
            ans = Math.max(ans, prices[i] - currMin);
            currMin = Math.min(currMin, prices[i]);
        }
        
        return ans;
    }
}