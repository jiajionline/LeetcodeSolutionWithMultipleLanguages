public class Solution {
    public int MinInsertions(string s) {
        if(string.IsNullOrEmpty(s)) return 0;
        int n = s.Length;
        var DP = new int[n,n];
        for (int l = 2; l <= n; ++l)
            for (int i = 0, j = l - 1; j < n; i++, j++)
                DP[i,j] = s[i] == s[j] ? DP[i+1,j-1] : Math.Min(DP[i,j - 1], DP[i + 1,j]) + 1;
        return DP[0,n-1];
    }
}