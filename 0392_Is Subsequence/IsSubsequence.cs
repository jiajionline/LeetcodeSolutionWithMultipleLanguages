public class Solution {
    public bool IsSubsequence(string s, string t) {
        if(string.IsNullOrEmpty(s)) return true;
        if(string.IsNullOrEmpty(t)) return false;
        
        var n = t.Length;
        var index = 0;
        
        foreach(var c in s)
        {
            while(index < n && c != t[index]) index++;
            if(index++ == n) return false;
        }

        return true;
    }
}