
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] rows: dp)
            Arrays.fill(rows, Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++)
            dp[i][i] = nums[i];
        
        for(int len=2;len<=n;len++){
            for(int l=0; l<=n-len;l++){
                int r=l+len-1;
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
            }
        }
    return dp[0][n-1] >= 0;
    }
}