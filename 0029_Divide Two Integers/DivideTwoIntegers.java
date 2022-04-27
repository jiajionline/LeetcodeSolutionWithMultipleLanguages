class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        long ans = 0;
        while(ldivisor <= ldividend) {
            long tmp = ldivisor;
            long mul = 1;
            while(ldividend >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            
            ans += mul;
            ldividend -= tmp;
        }
        
        ans *= sign;
        
        if(ans >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else{
            return (int) ans;
        }
    }
}