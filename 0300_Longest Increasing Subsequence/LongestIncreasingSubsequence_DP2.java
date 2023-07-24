class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    ans = Math.max(ans, dp[j]);
                }
            }
        }
        return ans;
    }
}