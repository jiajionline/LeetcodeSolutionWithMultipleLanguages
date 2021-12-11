public class Solution {
    public string LongestPalindrome(string s) {
        var n = s.Length;
        var dp = new bool[n, n];
        var ans = "";
        
        for(int len=1;len<=s.Length;len++)
        {
            for(int l=0;l+len<=s.Length;l++)
            {
                var r = l + len - 1;
                if(s[l] == s[r] && (r - l <= 2 || dp[l+1,r-1]))
                {
                    dp[l,r] = true;
                    if(r - l + 1 > ans.Length)
                        ans = s.Substring(l, r - l + 1);
                }
            }
        }
        
        return ans;
    }
}