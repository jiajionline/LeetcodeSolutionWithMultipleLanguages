public class Solution {
  public int LongestPalindromeSubseq(string s) {
    var n = s.Length; 
    var dp0 = new int[n];
    var dp1 = new int[n];
    var dp2 = new int[n];
    
    for (var l = 1; l <= n; ++l) {
      for (var i = 0; i <= n - l; ++i) {
        int j = i + l - 1;
        if (i == j) {
          dp0[i] = 1;
          continue;
        }
        if (s[i] == s[j])
          dp0[i] = dp2[i + 1] + 2;
        else
          dp0[i] = Math.Max(dp1[i], dp1[i + 1]);
      }
      var tmp = dp2;
      dp2 = dp1;
      dp1 = dp0;
      dp0 = tmp;
    }
    return dp1[0];
  }
}