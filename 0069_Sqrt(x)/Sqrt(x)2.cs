public class Solution {
    public int MySqrt(int x) {
        if(x<=1) return x;
        int l = 1;
        int r = x;
        while(l<=r){
            var m = l + (r-l)/2;
            if(m > x/m){
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return l - 1;
    }
}