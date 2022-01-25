public class Solution {
    public double MyPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        var ans = 1.0d;
        for(int i=1;i<=n;i++)
            ans *= x;
        
        return ans;
    }
}