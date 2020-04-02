class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num + 1;
        while(l < r){
            long m = (r-l)/2 + l;
            long t = m * m;
            if(t == num)
                return true;
            else if(t > num)
                r = m;
            else
                l = m+1;
        }

        return false;
    }
}
