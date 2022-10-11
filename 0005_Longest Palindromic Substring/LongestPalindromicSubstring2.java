class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int maxLen = 0;
        int index = -1;
        
        for(int len=1;len<=n;len++) {
            for(int l = 0; l + len <=n;l++) {
                int r = l + len - 1;
                if(s.charAt(l) == s.charAt(r) && (len<=3 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if(maxLen < len) {
                        maxLen = len;
                        index = l;    
                    }
                }
            }
        }
        
        return s.substring(index, index + maxLen);
    }
}