class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        
        while(l <= r)
        {
            long m = (r - l)/2 + l;
            if(num <= m * m)
                r = m - 1;
            else
                l = m + 1;
        }
        
        return l * l == num;
    }
}
