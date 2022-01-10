class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length-1);
        
        int l = 0;
        int r = 0;
        
        while(r < chars.length)
        {
            if(chars[r] == ' ') {
                reverse(chars,l, r-1);
                l=r+1;
            }
            r++;
        }
        
        reverse(chars, l , r-1);
        
        return new String(chars);
    }
    
    private void reverse(char[] chars, int l, int r) {
        while(l < r) {
            char ch = chars[l];
            chars[l++] = chars[r];
            chars[r--] = ch;
        }
    }
}