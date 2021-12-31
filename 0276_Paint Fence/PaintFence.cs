public class Solution {
    public int NumWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k * k;
        var lastSame = k;
        var lastDiff = k * k - k;
        var ans = 0;
        for(int i=3;i<=n;i++)
        {
            var currSame = lastDiff;
            var currDiff = (lastDiff + lastSame) * (k - 1);
            ans = currSame + currDiff;
            lastDiff = currDiff;
            lastSame = currSame;
        }
        
        return ans;
    }
}