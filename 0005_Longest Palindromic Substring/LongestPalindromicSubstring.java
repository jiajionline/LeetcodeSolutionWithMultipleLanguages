class Solution {
    private int max = 0;
    private int start = -1;
    private int end = -1;
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        for(int i=0;i<s.length();i++) {
            expand(i,i,s);
            expand(i,i+1,s);
        }
        
        return s.substring(start, end);
    }
    
    private void expand(int l, int r, String s) {
        int n = s.length();
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        
        if(r - l - 1 > max) {
            max = r-l-1;
            start = l + 1;
            end = r;
        }
    }
}