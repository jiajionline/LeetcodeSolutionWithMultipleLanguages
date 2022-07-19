class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return PredictTheWinner(nums, 0, nums.length-1, new Integer[n][n]) >= 0;
    }
    
    private int PredictTheWinner(int[] nums, int l, int r, Integer[][] memo) {
        if(l == r) return nums[l];
        if(memo[l][r] != null) return memo[l][r];
        int res = Math.max(nums[l] - PredictTheWinner(nums, l+1, r, memo), nums[r] - PredictTheWinner(nums, l , r-1, memo));
        memo[l][r] = res;
        return res;
    }
}