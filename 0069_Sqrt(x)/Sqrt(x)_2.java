class Solution {
    public int mySqrt(int x) {
        long l = 0, r = (long)x + 1;
        while(l < r) {
            long mid = (r-l)/2 + l;
            if(mid * mid > x) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        l = l-1;
        return (int)l;
    }
}