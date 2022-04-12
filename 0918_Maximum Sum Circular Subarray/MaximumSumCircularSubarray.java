
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans = Arrays.stream(nums).max().getAsInt();
        if(ans < 0) return ans;
        ans = Math.max(ans, maxSubarray(nums));
        
        int sum = IntStream.of(nums).sum();
        // Max(prefix + suffix) = Max(sum - mid)
        // Max(prefix + suffix) = Max(sum + (-mid))
        for(int i=0;i<nums.length;i++)
            nums[i] *= -1;
        
        ans = Math.max(ans, sum + maxSubarray(nums));
        
        return ans;
    }
    
    private int maxSubarray(int[] nums) {
        // dp[i] = dp[i-1] + nums[i] if dp[i-1] > 0 else nums[i]
        int ans = nums[0];
        int currMax = nums[0];
        
        for(int i=1;i<nums.length;i++) {
            if(currMax > 0) {
                currMax += nums[i];
            }else {
                currMax = nums[i];
            }
            
            ans = Math.max(ans, currMax);
        }
        
        return ans;
    }
}