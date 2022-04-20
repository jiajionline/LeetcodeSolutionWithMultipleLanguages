class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long l = 1;
        // need to convert x to long since if x is Integer.Max_Value, it overflows if it plus 1
        long r = (long)x + 1;
        //upperbound
        while(l < r) {
            long mid = (r-l)/2 + l;
            if(mid > x / mid) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        return (int)l - 1;
    }
}