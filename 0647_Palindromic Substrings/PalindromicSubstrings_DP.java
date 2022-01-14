class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int len = 1; len <= n ; len++)
            for(int l = 0; l <= n - len; l++) {
                int r = l + len - 1;
                if(isPalindrome(s, l , r, dp)) {
                    dp[l][r] = true;
                    ans++;
                }
            }
                
        return ans;
    }
    
    private boolean isPalindrome(String s, int l, int r, boolean[][] dp) {
        return s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1]);
    }
}