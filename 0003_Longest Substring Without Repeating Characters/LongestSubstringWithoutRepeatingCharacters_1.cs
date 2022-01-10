public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var arr = new int[128];
        var l = 0;
        var r = 0;
        var ans = 0;
        while(r < s.Length)
        {
            arr[s[r]]++;
            
            while(arr[s[r]] > 1)
            {
                arr[s[l++]]--;
            }
            
            ans = Math.Max(ans, r - l + 1);
            r++;
        }
        
        return ans;
    }
}