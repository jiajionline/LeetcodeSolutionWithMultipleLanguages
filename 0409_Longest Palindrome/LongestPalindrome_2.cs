public class Solution {
    public int LongestPalindrome(string s) {
        var ans = 0;
        var chars = new int[128];
        for(int i=0;i<s.Length;i++)
        {
            chars[s[i]]++;
        }
        
        var hasOdd = false;
        for(int i=0;i<chars.Length;i++)
        {
            if(chars[i] % 2 == 0)
            {
                ans += chars[i];
            }else{
                ans += (Math.Max(0, chars[i]-1));
                if(chars[i] > 0) hasOdd = true;
            }
        }
        
        if(hasOdd) ans++;
        
        return ans;
    }
}