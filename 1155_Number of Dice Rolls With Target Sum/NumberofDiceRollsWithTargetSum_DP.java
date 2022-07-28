class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int kMod = (int)(Math.pow(10,9) + 7);
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=k;j++) {
                for(int m = j; m<=target; m++) {
                    dp[i][m] = (dp[i][m] + dp[i - 1][m - j]) % kMod;
                }
            }
        }
        
        return dp[n][target];
    }
}