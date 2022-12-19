class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1;i<=n;i++){
            ans[i] = i%2 == 0 ? ans[i/2] : ans[i/2] + 1;
        }
        
        return ans;
    }
}