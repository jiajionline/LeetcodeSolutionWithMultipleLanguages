public class Solution {
    public int MinInsertions(string s) {
        if(string.IsNullOrEmpty(s)) return 0;
        var n = s.Length;
        var dp = new int[n, n];
        
        for(var len = 2;len <=n;len++)
            for(var l = 0; l <= n- len;l++)
            {
                var r = l + len - 1;
                if(s[l] == s[r])
                    dp[l,r] = dp[l+1,r-1];
                else
                    dp[l,r] = Math.Min(dp[l+1,r], dp[l,r-1]) + 1;
            }
        
        return dp[0,n-1];
    }
}