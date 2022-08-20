class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start = -1;
        
        for(int len=1;len <=n;len++) {
            for(int l = 0; l+len <= n;l++) {
                int r = l + len -1;
                if(len<=2 && s.charAt(l) == s.charAt(r)) dp[l][r] = true;
                else if(s.charAt(l) == s.charAt(r) && dp[l+1][r-1]) dp[l][r] = true;
                
                if(dp[l][r] && r-l+1 > maxLen) {
                 start = l;
                maxLen = Math.max(maxLen, len);
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}