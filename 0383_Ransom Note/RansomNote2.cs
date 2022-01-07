public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        var arr = new int[26];
        foreach(var c in magazine)
            arr[c-'a']++;
        
        foreach(var c in ransomNote)
        {
            if(arr[c-'a'] == 0) return false;
            arr[c-'a']--;
        }
        
        return true;
    }
}