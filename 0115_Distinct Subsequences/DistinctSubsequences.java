class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) return 0;
        //padding
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++) {
            dp[0][i] = 1;
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[n][m];
    }
}