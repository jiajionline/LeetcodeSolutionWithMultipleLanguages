class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        
        boolean positive = true;
        long ans = 0;
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
            
            ans = 10 * ans + digit;
            index++;
            
            if(positive && ans > Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            else if(!positive && -ans < Integer.MIN_VALUE)  return Integer.MIN_VALUE;      
        }
        
        
        return positive ? (int)ans : (int)ans * -1;
    }
}