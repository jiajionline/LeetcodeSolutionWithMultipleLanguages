class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int ans = 1;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+ 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        
        return ans;
    }
}