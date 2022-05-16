class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int v : nums) sum += v;
        if(sum % 2 != 0) return false;
        int v = sum / 2;
        int[][] memo = new int[nums.length][v+1];
        return backtrack(nums, 0, v, memo) == 2;
        
    }
    
    // memo 0 not computed, 1 : false, 2 : true
    private int backtrack(int[] nums, int index, int sum, int[][] memo) {
        if(index == nums.length) return 1;
        if(sum == 0) return 2;
        if(sum < 0) return 1;
        if(memo[index][sum] > 0) return memo[index][sum];
        
        int res = backtrack(nums, index + 1, sum , memo);
        memo[index][sum] = res;
        if(res == 2) return res;
        
        res = backtrack(nums, index + 1, sum - nums[index], memo);
        memo[index][sum] = res;
        return res;
    }
}