class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int valley = Integer.MAX_VALUE;
        int peak = valley;
        
        for(int v : prices) {
            if(v < peak) {
                ans += peak - valley;
                valley = v;
                peak = valley;
            }else{
                peak = v;
            }
        }
        
        ans += peak - valley;
        return ans;
    }
}