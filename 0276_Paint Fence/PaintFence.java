class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k * k;
        int lastSame = k;
        int lastDiff = k * (k-1);
        
        int ans = 0;
        for(int i=3;i<=n;i++) {
            int same = lastDiff;
            int diff = (lastSame + lastDiff) * (k - 1);
            ans = same + diff;
            lastSame = same;
            lastDiff = diff;
        }
        
        return ans;
    }   
}