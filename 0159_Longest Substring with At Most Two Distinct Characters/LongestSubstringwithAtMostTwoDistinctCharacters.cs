public class Solution {
    public int LengthOfLongestSubstringTwoDistinct(string s) {
        var dict = new Dictionary<char, int>();
        var l = 0;
        var ans = 0;
 
        for (int r = 0; r < s.Length; r++)
        {
            if (!dict.ContainsKey(s[r]))
                dict.Add(s[r], 0);
            dict[s[r]]++;
 
            while (dict.Count > 2)
            {
                if (dict.ContainsKey(s[l]))
                {
                    dict[s[l]]--;
                    if (dict[s[l]] == 0)
                        dict.Remove(s[l]);
                    l++;
                }
            }
            ans = Math.Max(ans, r - l + 1);
        }
 
        return ans;
    }
}