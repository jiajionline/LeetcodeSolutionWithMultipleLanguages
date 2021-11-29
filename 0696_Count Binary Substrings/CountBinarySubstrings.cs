public class Solution {
    public int CountBinarySubstrings(string s) {
        var group = new int[s.Length];
        group[0] = 1;
        var t = 0;
        for(int i=1;i<s.Length;i++)
        {
            if(s[i] == s[i-1])
                group[t]++;
            else
                group[++t]=1;
            
        }
        
        var ans = 0;
        for(int i=1;i<=t;i++)
        {
            ans += Math.Min(group[i], group[i-1]);
        }
        
        return ans;
    }
}