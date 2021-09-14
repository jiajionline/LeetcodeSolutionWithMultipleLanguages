public class Solution
{
    public int NumDistinct(string s, string t)
    {
        if (string.IsNullOrEmpty(s) || string.IsNullOrEmpty(t)) return 0;
        var tLen = t.Length + 1;
        var sLen = s.Length + 1;

        var dp = new int[tLen, sLen];

        for (int j = 0; j < sLen; j++)
        {
            dp[0,j] = 1;
        }

        for (int i = 1; i < tLen; i++)
        {
            for (int j = 1; j < sLen; j++)
            {
                if (t[i-1] == s[j-1])
                {
                    dp[i, j] = dp[i,j-1] + dp[i-1,j-1];
                }
                else
                {
                    dp[i, j] = dp[i, j - 1];
                }
            }
        }

        return dp[tLen-1,sLen-1];
    }
}