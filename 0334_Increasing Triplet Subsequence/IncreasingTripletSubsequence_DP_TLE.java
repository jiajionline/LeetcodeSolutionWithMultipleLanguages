class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] >=3) return true;
                }
            }
        }
        
        return false;
    }
}