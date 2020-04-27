class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i=0;i<n;i++)
            dp[i][i] = nums[i];
        
        for(int l=2;l<=n;l++){
            for(int i=0;i<=n-1;i++){
                int j=i+l-1;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
    return dp[0][n-1] >= 0;
    }
}