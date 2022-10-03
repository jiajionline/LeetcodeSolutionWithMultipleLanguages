class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int k=1;k<=amount;k++) {
            for(int c : coins) {
                if(k >= c) {
                    dp[k] = Math.min(dp[k], dp[k-c] + 1);
                }
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}