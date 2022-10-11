class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        long ans = 0;
        int index = 0;
        boolean isNegative = false;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(index == 0 && c == '-')
                    isNegative = true;
            else if(index == 0 && c == '+'){
                //ignore
            }
            else if(c >= '0' && c <= '9'){
                ans *= 10;
                ans += (c - '0');
            }else{
                break;
            }
            index++;
            
            if(!isNegative && ans > Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            else if(isNegative && -ans < Integer.MIN_VALUE)  return Integer.MIN_VALUE; 
        }
        
        return isNegative ? -1 * (int)ans : (int)ans;
    }
}