class Solution {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()) return s;
        int n = s.length();
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        while(r < n) {
            while(r < n && s.charAt(r) == ' ') r++;
            l = r;
            while(r < n && s.charAt(r) != ' ') r++;
            reverse(chars, l, r-1);
        }
        
        return new String(chars);
    }
    
    private void reverse(char[] chars, int l, int r) {
        if(l >= chars.length) return;
        while(l < r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }
}