class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = n % 2 == 1 ? n / 2 + 1 : n/2;
        
        int v = 1;
        for(;i < n; i++) {
            ans[i] = v;
            ans[n-i-1] = -v;
            v++;
        }
        
        return ans;
    }
}