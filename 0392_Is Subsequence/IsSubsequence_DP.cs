public class Solution {
    public bool IsSubsequence(string s, string t) {
        var m = s.Length;
        var n = t.Length;
        if(m == 0) return true;
        if(m > n) return false;
        
        var dp = new bool[m+1, n+1];
        
        //base case when s is empty, s is the subsequence of t. 
        for(int j=0; j<=n; j++) {
            dp[0,j] = true;
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s[i-1] == t[j-1]) {
                    dp[i,j] = dp[i-1,j-1];
                } else {
                    dp[i,j] = dp[i,j-1];
                }  
            }
        }
        
        return dp[m,n];
    }
}