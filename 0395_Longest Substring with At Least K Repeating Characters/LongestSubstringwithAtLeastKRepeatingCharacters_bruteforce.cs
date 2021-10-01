public class Solution {
    public int LongestSubstring(string s, int k) {
        if(string.IsNullOrEmpty(s) || s.Length < k) return 0;
        
        var counters = new int[26];
        var ans = 0;
        
        for(int start = 0; start < s.Length; start++)
        {
            Array.Fill(counters, 0);
            for(int end = start; end < s.Length; end++)
            {
                counters[s[end] - 'a']++;
                if(IsValid(s, k, counters))
                {
                    ans = Math.Max(ans, end - start + 1);
                }
            }
        }
        
        return ans;
    }
    
    private bool IsValid(string s, int k, int[] counters)
    {
        var letters = 0;
        var atLeastKs = 0;
        foreach(var v in counters)
        {
            if(v > 0) letters++;
            if(v >= k) atLeastKs++;
        }
        
        return letters == atLeastKs;
    }
}