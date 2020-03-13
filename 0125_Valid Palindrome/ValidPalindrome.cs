public class Solution {
    public bool IsPalindrome(string s) {
        if(string.IsNullOrEmpty(s)) return true;
        s = s.ToLower().Trim();
        var l = 0;
        var r = s.Length-1;
        while(l < r){
            while(l < r && !IsAlphanumeric(s[l])) l++;
            while(l < r && !IsAlphanumeric(s[r])) r--;
            if(s[l++] != s[r--]) return false;
        }
        
        return true;
    }
    
    private bool IsAlphanumeric(char c){
        if((c >= 'a' && c <='z') || (c >='A' && c <='Z') || (c >='0' && c <='9'))
            return true;
        return false;
    }
}