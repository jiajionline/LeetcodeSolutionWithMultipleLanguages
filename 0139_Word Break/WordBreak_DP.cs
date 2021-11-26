public class Solution {
    public bool WordBreak(string s, IList<string> wordDict)
    {
        if (string.IsNullOrWhiteSpace(s)) return false;
        var set = new HashSet<string>(wordDict);
        var dp = new bool[s.Length + 1];
        dp[0] = true;

        for (int i = 1; i <= s.Length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                var canBreak = dp[j] && set.Contains(s.Substring(j, i - j));
                if (canBreak)
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.Length - 1];
    }
}
