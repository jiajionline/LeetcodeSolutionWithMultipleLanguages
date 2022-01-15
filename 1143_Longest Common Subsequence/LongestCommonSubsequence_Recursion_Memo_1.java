class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      int[][] memo = new int[m + 1][n + 1];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          memo[i][j] = -1;
        }
      }
    
    return LCS(text1, 0, text2, 0, memo);
  }

  private int LCS(String text1, int p1, String text2, int p2, int[][] memo) {        
    
    if (memo[p1][p2] != -1) {
      return memo[p1][p2];
    }

    int ans = 0;
    if (text1.charAt(p1) == text2.charAt(p2)) {
      ans = 1 + LCS(text1, p1 + 1, text2, p2 + 1, memo);
    } else {
      ans = Math.max(LCS(text1, p1, text2, p2 + 1, memo), LCS(text1, p1 + 1, text2, p2, memo));
    }
    
    memo[p1][p2] = ans;
    return memo[p1][p2];
  }
}