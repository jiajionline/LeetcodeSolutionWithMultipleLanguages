class Solution {
    public int jump(int[] nums) {
        //next = min(next, curr + 1)
        int[] dp = new int[nums.length];
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=1;i<nums.length;i++){
            int jumpSteps = nums[i-1];
            
            for(int j=i-1;j<Math.min(nums.length,jumpSteps + i);j++){
                dp[j] = Math.min(dp[j], dp[i-1] + 1);
            }
        }
        
        return dp[dp.length-1];
    }
}