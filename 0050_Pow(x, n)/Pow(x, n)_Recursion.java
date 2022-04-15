class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        return pow(x, n);
    }
    
    public double pow(double x, int n) {
        if(n == 0) return 1;
        double r = pow(x, n/2);
        if(n % 2 == 0) {        
            return r * r;
        }else {
            return r * r * x;
        }
    }
}