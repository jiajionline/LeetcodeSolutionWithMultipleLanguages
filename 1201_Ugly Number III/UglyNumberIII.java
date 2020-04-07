public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a,b);
        long ac = lcm(a,c);
        long bc = lcm(b,c);
        long abc = lcm(a,bc);
        int l = 1, r = Integer.MAX_VALUE;


        while (l < r) {
            int m = l + (r - l) / 2;
            long k = m/a + m/b + m/c - m/ab - m/bc -m/ac + m/abc;
            if(k >= n){
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;
    }

    private long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}