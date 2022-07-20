class Solution {
    public boolean divisorGame(int n) {
        return canWin(n, new Boolean[n+1]);
    }
    
    private boolean canWin(int n, Boolean[] dp) {
        if(n == 1) return false;
        if(dp[n] != null) return dp[n];
        boolean canWin = false;
        for(int i=1;i<=n/2;i++) {
            if(n % i == 0 && !canWin(n-i, dp)) {
                canWin = true;
                break;
            }
        }
        
        dp[n] = canWin;
        return canWin;
    }
}