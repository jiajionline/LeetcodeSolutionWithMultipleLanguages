public class Solution {
    public int LongestPalindromeSubseq(string s) {
        var n = s.Length;
        var dp = new int[n,n];
        
        for(var len = 1; len <= n; len++)
            for(var l = 0; l <= n-len; l++) {
                var r = l + len - 1;
                
                if(l == r)
                {
                    dp[l,r] = 1;
                    continue;
                }
                
                if(s[l] == s[r])
                    dp[l,r] = Math.Max(dp[l,r], dp[l+1,r-1] + 2);
                else
                    dp[l,r] = Math.Max(dp[l,r-1], dp[l+1,r]);
            }
        
        return dp[0,n-1];
    }
}