public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var arr = new int[128];
        var l = 0;
        var r = 0;
        var ans = 0;
        while(r < s.Length)
        {
            if(arr[s[r]] == 0)
            {
                arr[s[r]]++;
                ans = Math.Max(ans, r-l+1);
            }else{
                while(s[l] != s[r])
                {
                    arr[s[l++]]--;
                }
                l++;
            }
            
            r++;
        }
        
        return ans;
    }
}