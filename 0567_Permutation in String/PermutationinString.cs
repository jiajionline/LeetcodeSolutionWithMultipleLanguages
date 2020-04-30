public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        int len1 = s1.Length; 
        int len2 = s2.Length;
        if (len1 > len2) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1[i] - 'a']++;
            count[s2[i] - 'a']--;
        }
        if (AllZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[s2[i] - 'a']--;
            count[s2[i - len1] - 'a']++;
            if (AllZero(count)) return true;
        }
        
        return false;
    }
    
    private bool AllZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}