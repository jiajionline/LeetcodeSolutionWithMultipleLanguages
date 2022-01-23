public class Solution {
    public bool IsSubsequence(string s, string t) {
        return IsSubsequence(s, t, 0, 0);
    }
    
    private bool IsSubsequence(string s, string t, int sIndex, int tIndex)
    {
        if(sIndex == s.Length) return true;
        if(tIndex == t.Length) return false;
        
        if(s[sIndex] == t[tIndex])
            sIndex++;
        tIndex++;
        return IsSubsequence(s, t, sIndex, tIndex);
    }
}