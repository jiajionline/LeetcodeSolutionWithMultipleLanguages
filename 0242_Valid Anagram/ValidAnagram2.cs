public class Solution {
    public bool IsAnagram(string s, string t) {
        if(string.IsNullOrEmpty(s) && string.IsNullOrEmpty(t)) return true;
        if(string.IsNullOrEmpty(s) || string.IsNullOrEmpty(t)) return false;
        if(s.Length != t.Length) return false;
        
        var count = new int[26];
        foreach(var c in s)
        {
            count[c-'a']++;
        }
        
        foreach(var c in t)
        {
            count[c-'a']--;
        }
        
        return !(count.Where(t=> t!=0).Count() > 0);
    }
}