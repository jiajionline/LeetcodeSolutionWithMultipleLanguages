class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] chars = new char[num.length()];
        for(int i=0;i<num.length();i++) {
            char c = num.charAt(i);
            if(c == '6') chars[i] = '9';
            else if(c == '9') chars[i] = '6';
            else if(c == '0' || c == '1' || c == '8') chars[i] = c;
            else return false;
        }
        
        flip(chars);
        return num.equals(new String(chars));
        
    }
    
    private void flip(char[] chars) {
        int l = 0, r = chars.length-1;
        while(l < r) {
            char c = chars[l];
            chars[l++] = chars[r];
            chars[r--] = c;
        }
    }
}