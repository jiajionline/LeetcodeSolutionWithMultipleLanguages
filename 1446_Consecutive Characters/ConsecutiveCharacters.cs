public class Solution {
    public int MaxPower(string s) {
        if(s.Length == 1) return 1;
        var ans = 1;
        var curr = 1;
        for(int i=1;i<s.Length;i++)
        {
            if(s[i] == s[i-1])
            {
                curr++;
                ans = Math.Max(ans, curr);
            }else{
                curr = 1;
            }
        }
        
        return ans;
    }
}