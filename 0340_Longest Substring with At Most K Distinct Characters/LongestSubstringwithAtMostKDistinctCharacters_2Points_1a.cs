public class Solution
{
    public int LengthOfLongestSubstringKDistinct(string s, int k)
    {
        var dict = new Dictionary<char, int>();
        var l = 0;
        var r = 0;
        var ans = 0;
        var currCount = 0;

        while (r < s.Length)
        {
            if (!dict.ContainsKey(s[r]))
                dict.Add(s[r], 0);
            dict[s[r++]]++;
            currCount++;

            if (dict.Count <= k)
            {
                ans = Math.Max(ans, currCount);
            }

            while (dict.Count > k)
            {
                if (dict.ContainsKey(s[l]))
                {
                    dict[s[l]]--;
                    currCount--;
                    if (dict[s[l]] == 0)
                        dict.Remove(s[l]);
                    l++;
                }
            }
        }
        return ans;
    }
}