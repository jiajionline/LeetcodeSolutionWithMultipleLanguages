class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        
        int l = 0;
        int r = 0;
        int ans = 0;
        
        while(r < s.length()) {
            char r_ch = s.charAt(r);
            chars[r_ch]++;
            
            while(chars[r_ch] > 1) {
                char l_ch = s.charAt(l);
                chars[l_ch]--;
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        
        return ans;
    }
}