public class Solution {
    public int[] CountBits(int n) {
        var ans = new int[n+1];
        
        for(int i=1;i<=n;i++){
            if(i % 2 == 0) {
                ans[i] = ans[i/2];
            }else{
                ans[i] = ans[i/2] + 1;
            }
        }
        
        return ans;
    }
}