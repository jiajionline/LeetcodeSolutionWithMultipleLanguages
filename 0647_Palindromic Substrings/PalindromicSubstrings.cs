class Solution
{
    public int CountSubstrings(string s)
    {
        int ans = 0;
        for (int i = 0; i < s.Length; i++)
        {

            ans += SubCount(s,i,i);
            ans += SubCount(s,i,i+1);
        }

        return ans;
    }

    private int SubCount(string s, int start, int end)
    {
        int ans = 0;
        while (start >= 0 && end < s.Length && s[start] == s[end])
        {
            ans++;
            start--;
            end++;
        }
        return ans;
    }
}
