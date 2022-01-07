public class Solution {
    public int MaxSubarraySumCircular(int[] nums) {
        var max = nums.Max();
        if(max < 0) return max;
        var ans = MaxSubarraySum(nums);
        
        var sum = nums.Sum();
        for(int i=0;i<nums.Length;i++)
            nums[i] *= -1;
        
        return Math.Max(ans, sum + MaxSubarraySum(nums));
    }
    
    private int MaxSubarraySum(int[] nums)
    {
        var ans = nums[0];
        var currMax = nums[0];
        
        for(int i=1;i<nums.Length;i++)
        {
            if(currMax < 0) 
            {
                currMax = nums[i];
            }else
                currMax += nums[i];
            
            ans = Math.Max(ans, currMax);
        }
        
        return ans;
    }
}