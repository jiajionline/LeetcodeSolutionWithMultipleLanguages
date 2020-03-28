class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            presum[i] = nums[i] + presum[i - 1];
        }

        int[][] dp = new int[m+1][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<n;i++){
            dp[1][i] = presum[i];
        }

        for (int i = 2; i <= m; ++i)
        for (int j = i - 1; j < n; ++j)
          for (int k = 0; k < j; ++k)
            dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], presum[j] - presum[k]));
     
        return dp[m][n - 1];
    }
}