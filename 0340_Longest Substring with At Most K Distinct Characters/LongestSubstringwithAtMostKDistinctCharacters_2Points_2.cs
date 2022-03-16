public class Solution {
    public int LengthOfLongestSubstringKDistinct(string s, int k) {
        var dict = new Dictionary<char,int>();
        var l = 0;
        var ans = 0;
        
        for(int r=0;r<s.Length;r++)
        {
            if(!dict.ContainsKey(s[r])) dict.Add(s[r],r);
            dict[s[r]] = r;
            
            while(dict.Count > k)
            {
                if(dict.ContainsKey(s[l]))
                {
                    if(dict[s[l]] == l) dict.Remove(s[l]);
                }
                l++;
            }
            
            ans = Math.Max(ans, r - l + 1);
        }
        
        return ans;
    }
}