
public class ReverseInteger {
    public int reverse(int x) {
        long value = 0L;
        boolean negative = x < 0;        
        long y = x;
        y = Math.abs(y);
        
        while(y > 0){
        	value *= 10;
        	value += y % 10;
        	y /= 10;
        }
        
        if(value > Integer.MAX_VALUE){
        	return 0;
        }
        
        int ret = (int)value;
        if(negative){
        	return 0 - ret;
        }else{
        	return ret;
        }
    }
}
