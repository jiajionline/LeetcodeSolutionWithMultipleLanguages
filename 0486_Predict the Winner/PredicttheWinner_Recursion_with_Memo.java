class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return PredictTheWinner(nums, 0, nums.length-1, memo) >= 0;
    }
    
    private int PredictTheWinner(int[] nums, int l, int r, int[][] memo) {
        if(l == r) return nums[l];
        if(memo[l][r] != Integer.MIN_VALUE) return memo[l][r];
        int res = Math.max(nums[l] - PredictTheWinner(nums, l+1, r, memo), nums[r] - PredictTheWinner(nums, l , r-1, memo));
        memo[l][r] = res;
        return res;
    }
}