class Solution {
    private int maxLen;
    private int index;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++) {
            longestPalindrome(s, i, i);
            longestPalindrome(s, i, i+1);
        }
        
        return s.substring(index, index + maxLen);
    }
    
    private void longestPalindrome(String s, int l , int r) {
        int len = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        
        len = r - l - 1;
        if(len > this.maxLen) {
            this.maxLen = len;
            this.index = l+1;
        }
    }
}