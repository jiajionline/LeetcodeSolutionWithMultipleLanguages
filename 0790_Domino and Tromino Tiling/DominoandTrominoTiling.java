class Solution {
    public int numTilings(int N) {
        
        int KMOD = 1000000007;
        
        long[][] dp = new long[N+1][2];
        
        // dp[i][0] = dp[i-2][0] + dp[i-1][0] + 2 * dp[i-1][1]
        // dp[i][1] = dp[i-2][0] + dp[i-1][1]
        
        dp[0][0] = 1;
        dp[1][0] = 1;
        
        for(int i=2;i<=N;i++)
        {
            dp[i][0] = (dp[i-2][0] + dp[i-1][0] + 2 * dp[i-1][1]) % KMOD;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1]) % KMOD;
        }
        
        return (int)dp[N][0];
    }
}