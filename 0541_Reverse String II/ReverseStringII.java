class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0, n = chars.length;
        
        while(r < n) {
            if(r + k <= n) {
                r = r + k;
                reverse(chars, l , r - 1);
                l = r;
            }else {
                reverse(chars, l, n-1);
                break;
            }
            
            if(r + k <= n) {
                r += k;
                l = r;
            }else{
                break;
            }
        }
        
        return new String(chars);
    }
    
    private void reverse(char[] chars, int l , int r) {
        while(l < r) {
            char c = chars[l];
            chars[l++] = chars[r];
            chars[r--] = c;
        }
    }
}