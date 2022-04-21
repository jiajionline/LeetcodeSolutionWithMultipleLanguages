class Solution {
    public int numTrees(int n) {
        return numTrees(n, new int[n+1]);
    }
    
    private int numTrees(int n, int[] memo) {
        if(n <= 1) return 1;
        if(memo[n] > 0) return memo[n];
        
        int ans = 0;
        for(int root = 1 ; root <= n ; root++) {
            int left = numTrees(root - 1, memo);   
            int right = numTrees(n - root, memo);
            ans += left * right;
            memo[n] = ans;
        }
        
        return ans;
    }
}