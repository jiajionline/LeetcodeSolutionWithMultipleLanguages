class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      int[][] memo = new int[m + 1][n + 1];
      for (int i = 0; i < m+1; i++) {
        for (int j = 0; j < n+1; j++) {
          memo[i][j] = -1;
        }
      }
    
    return LCS(text1, m, text2, n, memo);
  }

  private int LCS(String text1, int m, String text2, int n, int[][] memo) {        
    
      if(m == 0 || n == 0) return 0;
    if (memo[m][n] != -1) {
      return memo[m][n];
    }

    int ans = 0;
    if (text1.charAt(m-1) == text2.charAt(n-1)) {
      ans = 1 + LCS(text1, m-1, text2, n-1, memo);
    } else {
      ans = Math.max(LCS(text1, m-1, text2, n, memo), LCS(text1, m, text2, n-1, memo));
    }
    
    memo[m][n] = ans;
    return ans;
  }
}