class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i], -1);
        
        return dfs(arr, 0, n-1, memo);
        
    }
    
    private int dfs(int[] arr, int l, int r, int[][] memo) {
        if(l > r) return 0;
        if(l == r) return 1;
        if(memo[l][r] != -1) return memo[l][r];
        
        //base case, remove one letter each time
        int res = 1 + dfs(arr, l+1, r, memo);
        
        for(int k = l + 1; k<=r; k++) {
            if(arr[l] == arr[k])
                res = Math.min(res, Math.max(1, dfs(arr,l+1, k-1, memo)) + dfs(arr,k+1, r , memo));
        }
        
        memo[l][r] = res;
        return res;
    }
}