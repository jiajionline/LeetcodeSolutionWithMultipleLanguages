public class Solution {
    public int[] CountBits(int n) {
        var ans = new int[n+1];
        
        for(int i=1;i<=n;i++){
            ans[i] = ans[(i & (i-1))] + 1;
        }
        
        return ans;
    }
}