class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    
     private double pow(double x, long n) {
        if(n < 0) return 1 / pow(x, -n);
        if(n == 0) return 1.0;
        if(n % 2 == 0) {
            double v = pow(x, n/2);
            return v * v;
        }else{
            return x * pow(x, n-1);
        }
    }
}