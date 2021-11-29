public class Solution {
    public int CountBinarySubstrings(string s) {
        var ans = 0;
        var prev = 0;
        var curr = 1;
        
        for(int i=1;i<s.Length;i++)
        {
            if(s[i] == s[i-1])
            {
                curr++;
            }else{
                ans += Math.Min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        
        ans += Math.Min(prev, curr);
        return ans;
    }
}