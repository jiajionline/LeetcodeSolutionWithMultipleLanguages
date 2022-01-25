public class Solution {
    public double MyPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        return calc(x, n);
    }
    
    private double calc(double x, int n) {
        if(n == 0) return 1.0;
        
        double half = calc(x, n/2);
        if(n % 2 == 0) 
            return half * half;
        else
            return half * half * x;
    }
}