
public class Solution {
    public boolean isPalindrome(int x) {
        if(x == Integer.MIN_VALUE) return false;
        long y = Math.abs(x);
        long value = 0;
        
        while(y>0){
        	value *= 10;
        	value += (y % 10);
        	y /= 10;
        }
        
        if(value > Integer.MAX_VALUE) return false;
        return x == (int)value;
    }
}
