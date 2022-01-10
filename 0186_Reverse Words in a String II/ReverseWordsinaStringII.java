class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int l = 0;
        int r = 0;
        while(r < s.length) {
            if(s[r] == ' ') {
                reverse(s, l, r-1);
                l = r+1;
            }
            r++;
        }
        
        reverse(s, l, r-1);
    }
    
    private void reverse(char[] s, int l , int r) {
        while(l < r) {
            char ch = s[l];
            s[l++] = s[r];
            s[r--] = ch;
        }
    }
}