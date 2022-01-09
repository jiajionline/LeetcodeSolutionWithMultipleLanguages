class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        boolean positive = true;
        int ans = 0;
        int index = 0;
        int n = s.length();
        
        if(index < n && s.charAt(index) == '+') {
            positive = true;
            index++;
        }else if(index < n && s.charAt(index) == '-') {
            positive = false;
            index++;
        }
        
        while(index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            //check overflow & underflow
            if( ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            ans = 10 * ans + digit;
            index++;
        }
        
        return positive ? ans : ans * -1;
    }
}