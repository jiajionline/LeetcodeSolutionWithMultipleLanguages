public class Solution {
    public int CoinChange(int[] coins, int amount) {
        var dp = new int[amount+1];
        Array.Fill(dp, amount+1);
        dp[0] = 0;
        for(int k=1;k<=amount;k++) {
            for(int j=0;j<coins.Length;j++) {
                if(k >= coins[j]) {
                    dp[k] = Math.Min(dp[k], dp[k - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}