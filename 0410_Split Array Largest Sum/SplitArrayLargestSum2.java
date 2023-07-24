class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            presum[i] = nums[i] + presum[i - 1];
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            dp[1][i] = presum[i];
        }

        for (int i = 2; i <= k; ++i)
            for (int j = i - 1; j < n; ++j)
                for (int z = 0; z < j; ++z)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][z], presum[j] - presum[z]));

        return dp[k][n - 1];
    }
}
