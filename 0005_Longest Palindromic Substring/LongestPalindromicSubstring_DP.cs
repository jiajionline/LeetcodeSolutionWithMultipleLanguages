public class Solution {
    public string LongestPalindrome(string s) {
        var n = s.Length;
        var dp = new bool[n,n];
        var ans = 0;
        var start = 0;
        
        for(var len = 1;len<=n;len++)
            for(var l = 0;l<=n-len;l++)
            {
                var r = l + len - 1;
                if(s[l] == s[r] && (r-l <= 2 || dp[l+1,r-1]))
                {
                    dp[l,r] = true;
                    if(len > ans)
                    {
                        ans = len;
                        start = l;
                    }
                }
            }
        return s.Substring(start, ans);
    }
}