class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }
        
        for(int len = 2; len<=n;len++) {
            for(int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                
                 char chL = s.charAt(l);
                 char chR = s.charAt(r);
                
                if((chL == '(' || chL == '*') && (chR == ')' || chR == '*') && (len == 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    continue;
                }
                
                for(int p = l;p<r;p++) {
                    if(dp[l][p] && dp[p+1][r]) {
                        dp[l][r] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}