class Solution {
    private int[][] memo;
    private int[] vals;
    public int maxCoins(int[] nums) {
      int n = nums.length;
      vals = new int[n + 2];
      vals[0] = vals[n + 1] = 1;
      for (int i = 0; i < n; ++i){
        vals[i + 1] = nums[i];
      } 
      memo = new int[n + 2][n + 2];
      return maxCoins(1, n);
    }
    
    private int maxCoins(int i, int j) {
      if (i > j) return 0;
      if (i == j) return vals[i - 1] * vals[i] * vals[i + 1];
      if (memo[i][j] > 0) return memo[i][j];
      int most = 0;
      for (int k = i; k <= j; ++k)
        most = Math.max(most, maxCoins(i, k - 1) + vals[i - 1] * vals[k] * vals[j + 1] + maxCoins(k + 1, j));
      memo[i][j] = most;
      return memo[i][j];
    }
  }