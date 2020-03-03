public class Solution
{
    public int LongestPalindrome(string s)
    {
        if (s == null || s.Length == 0) return 0;
        var set = new HashSet<char>();
        int ans = 0;
        foreach (var c in s)
        {
            if (set.Contains(c))
            {
                set.Remove(c);
                ans += 2;
            }
            else
            {
                set.Add(c);
            }
        }

        return set.Count > 0 ? ans + 1 : ans;
    }
}