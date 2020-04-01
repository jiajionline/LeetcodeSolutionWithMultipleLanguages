class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        boolean[][] palindromeCache = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || palindromeCache[j + 1][i - 1])) {
                    palindromeCache[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, dp[j - 1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}