class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        boolean negative = x < 0;
        x = Math.abs(x);
        
        long y = 0;
        while(x > 0)
        {
            y *= 10;
            y += (x % 10);
            x /= 10;
        }
        
        if(y > Integer.MAX_VALUE) return 0;
        int ans = (int)y;
        
        return negative ? -ans : ans;
    }
}