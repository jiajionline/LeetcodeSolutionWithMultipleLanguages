class Solution {
    public int numDecodings(String s) {
        if(s.isBlank() || s.charAt(0) == '0') return 0;
        int n = s.length();
        if(n == 1) return 1;
        
        //the count of the last char
        int w1 = 1;
        //the count of the last second char
        int w2 = 1;
        
        for(int i=1;i<n;i++) {
            int w = 0;
            if(!isValid(s.charAt(i)) && !isValid(s.charAt(i-1), s.charAt(i))) return 0;
            if(isValid(s.charAt(i))) w = w1;
            if(isValid(s.charAt(i-1), s.charAt(i))) w += w2;
            w2 = w1;
            w1 = w;
        }
        
        return w1;
    }
    
    private boolean isValid(char c) {
        return c != '0';
    }
    
    private boolean isValid(char c1, char c2) {
        int v = (c1 - '0') * 10;
        v += (c2 - '0');
        
        return v >= 10 && v <= 26;
    }
}