class Solution {
    private int ans = 0;
    private final static int MOD = (int)(Math.pow(10, 9) + 7);
    public int numRollsToTarget(int n, int k, int target) {
        backtracking(n, k, 0, 0, target);
        return ans;
    }
    
    private void backtracking(int n, int k, int index, int sum, int target) {
        if(index == n) {
            if(sum == target) {
                ans++;
                ans %= MOD;
            }
            return;
        }
        
        for(int i=1;i<=k;i++) {
            sum += i;
            backtracking(n, k, index+1, sum, target);
            sum -= i;
        }
    }
}