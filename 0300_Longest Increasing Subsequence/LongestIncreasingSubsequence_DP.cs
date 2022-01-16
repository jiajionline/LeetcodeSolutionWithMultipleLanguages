public class Solution {
    public int LengthOfLIS(int[] nums) {
        var dp = Enumerable.Repeat(1, nums.Length).ToArray();
        var ans = 0;
        
        for(int i=0;i<nums.Length;i++) 
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i] > nums[j])
                    dp[i] = Math.Max(dp[i], dp[j] + 1);
            }
            
            ans = Math.Max(ans, dp[i]);
        }
        
        return ans;
    }
}