class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = piles[i];
        
        for(int len = 2;len<=n;len++) {
            for(int l = 0; l <= n - len;l++) {
                int r = l + len - 1;
                dp[l][r] = Math.max(piles[l] - dp[l+1][r], piles[r] - dp[l][r-1]);
            }
        }
        
        return dp[0][n-1] > 0;
    }
}