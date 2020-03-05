public class Solution {
  public int LongestPalindromeSubseq(string s) {
    var n = s.Length; 
    var dp = new int[n,n];
    
    for (var l = 1; l <= n; ++l) {
      for (var i = 0; i <= n - l; ++i) {
        int j = i + l - 1;
        if (i == j) {
          dp[i,j] = 1;
          continue;
        }
        if (s[i] == s[j])
          dp[i,j] = dp[i + 1,j-1] + 2;
        else
          dp[i,j] = Math.Max(dp[i+1,j], dp[i,j-1]);
      }
    }
    return dp[0,n-1];
  }
}