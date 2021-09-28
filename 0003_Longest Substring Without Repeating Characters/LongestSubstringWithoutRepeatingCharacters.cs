public class Solution {
    public int LengthOfLongestSubstring(string s) {
        if(string.IsNullOrEmpty(s)) return 0;
        var set = new HashSet<char>();
        
        var start = 0;
        var end = 0;
        var ans = 0;
        while(end < s.Length)
        {
            if(!set.Contains(s[end]))
            {
                set.Add(s[end++]);
                ans = Math.Max(ans, set.Count);
            }else{
                while(s[start] != s[end])
                {
                    set.Remove(s[start++]);
                }
                start++;
                end++;
            }
        }
        
        return ans;
    }
}